/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.flume.service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.flume.ha.ActiveStandbyElector;
import org.apache.flume.ha.ActiveStandbyElector.ActiveStandbyElectorCallback;
import org.apache.flume.lifecycle.LifecycleAware;
import org.apache.flume.node.Application;
import org.apache.flume.node.PollingZooKeeperConfigurationProvider;
import org.apache.flume.service.FlumeControllerService.Iface;
import org.apache.flume.util.AddressUtils;
import org.apache.flume.util.PropertiesUtil;
import org.apache.flume.util.ZooKeeperSingleton;
import org.apache.thrift.TException;
import org.apache.velocity.runtime.directive.Foreach;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FlumeControllerServiceImpl implements Iface {
	private static final Logger logger = LoggerFactory.getLogger(FlumeControllerServiceImpl.class);
	private ConcurrentHashMap<String, Application> map = new ConcurrentHashMap<String, Application>();

	public static final String MDC_AGENTNAME = "agentname";

	@Override
	public ResponseState startFlumeAgent(FlumeAgent agent) throws TException {
		ResponseState res = new ResponseState();
		res.setStatus(Status.OK);
		res.setMsg("success");
		try {

			checkServiceState(agent.getSourceList());

			String agentName = agent.getAgentName();
			MDC.put(MDC_AGENTNAME, agentName);

			String zkAgentPath = getAgentBasePath();

			ZooKeeper zk = ZooKeeperSingleton.getInstance().getZk();

			Stat stat = zk.exists(zkAgentPath + "/" + agentName, true);
			if (stat == null) {
				saveOrUpdateConf(agent);
			}

			ActiveStandbyElector elector = new ActiveStandbyElector("localhost:2181", 5 * 1000, "/flume_test/a",
					new ElectorCallbacks(), 3, true, agentName);

			Application application = null;

			EventBus eventBus = new EventBus(agentName + "-event-bus");
			List<LifecycleAware> components = Lists.newArrayList();
			String zkAddress = PropertiesUtil.readValue("zkAddress");
			PollingZooKeeperConfigurationProvider zookeeperConfigurationProvider = new PollingZooKeeperConfigurationProvider(
					agentName, zkAddress, zkAgentPath, eventBus);
			components.add(zookeeperConfigurationProvider);
			application = new Application(components);
			eventBus.register(application);

			application.start();

			add2zk(agentName);
			map.put(agentName, application);

		} catch (Exception e) {
			res.setMsg(e.getMessage());
			res.setStatus(Status.FAILED);
			logger.error("A fatal error occurred while start flume agent. Exception follows.", e);
		} finally {
			MDC.remove(MDC_AGENTNAME);
		}

		return res;
	}

	private void checkServiceState(List<FlumeSource> sourceList) {
		for (FlumeSource flumeSource : sourceList) {
			
		}
		
	}

	/**
	 * 启动成功的节点保存在zk里 ,flume重启的时候从zk里加载已经启动的agent列表,来决定启动哪些agent 目录节点
	 * /flume/activelist/${agentname}/${host1} /${host2}
	 * 
	 * @param agentName
	 */
	private void add2zk(String agentName) {
		ZooKeeper zk = ZooKeeperSingleton.getInstance().getZk();

		try {
			String activeAgentPath = PropertiesUtil.readValue("zk.agent.activelist");
			Stat stat = zk.exists(activeAgentPath + agentName, true);
			if (stat == null) {
				zk.create(activeAgentPath + agentName, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			zk.create(activeAgentPath + agentName + "/" + AddressUtils.getHostIp(), null, Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResponseState stopFlumeAgent(String agentName) throws TException {
		ResponseState res = new ResponseState();
		res.setStatus(Status.OK);
		res.setMsg("success");

		try {
			ZooKeeper zk = ZooKeeperSingleton.getInstance().getZk();
			String activeAgentPath = PropertiesUtil.readValue("zk.agent.activelist");
			zk.delete(activeAgentPath + agentName + "/" + AddressUtils.getHostIp(), -1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			MDC.put(MDC_AGENTNAME, agentName);
			if (map.get(agentName) != null) {
				map.get(agentName).stop();
				return res;
			} else {
				res.setMsg("the flume { " + agentName + " } is not running  ");
				res.setStatus(Status.FAILED);
				logger.error("stop flume agent error,the flume agent {} is not running ", agentName);
			}
		} finally {
			MDC.remove(MDC_AGENTNAME);
		}
		return res;
	}

	@Override
	public ResponseState saveOrUpdateConf(FlumeAgent agent) throws TException {
		ResponseState res = new ResponseState();
		res.setStatus(Status.OK);
		res.setMsg("success");
		try {
			String agentName = agent.getAgentName();
			Configuration cfg = new Configuration();
			cfg.setObjectWrapper(new DefaultObjectWrapper());

			ClassLoader classLoader = getClass().getClassLoader();
			URL url = classLoader.getResource("flume.ftl");
			String fileStr = url.getFile();
			File file = new File(fileStr);
			cfg.setDirectoryForTemplateLoading(file.getParentFile());
			Template temp = cfg.getTemplate(file.getName());

			ByteArrayOutputStream bOutput = new ByteArrayOutputStream(2048);
			Writer writer = new BufferedWriter(new OutputStreamWriter(bOutput, "UTF-8"));

			temp.process(agent, writer);
			writer.flush();
			writer.close();

			logger.info("saveOrUpdateConf ,the name is {} ,the  conf is {}", agentName, bOutput.toString());

			byte[] data = bOutput.toByteArray();
			ZooKeeper zk = ZooKeeperSingleton.getInstance().getZk();

			String zkAgentPath = getAgentBasePath();
			if (!zkAgentPath.endsWith("\\/")) {
				zkAgentPath = zkAgentPath + "/";
			}
			// 创建一个目录节点
			Stat stat = zk.exists(zkAgentPath + agentName, true);
			if (stat == null) {
				zk.create(zkAgentPath + agentName, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} else {
				zk.delete(zkAgentPath + agentName, stat.getVersion());
				zk.create(zkAgentPath + agentName, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}

		} catch (Exception e) {
			res.setMsg(e.getMessage());
			res.setStatus(Status.FAILED);
			logger.error("save or update flume conf error ,the error msg is ", e);
		}

		return res;
	}

	public String getAgentBasePath() throws Exception {
		String zkAgentPath = PropertiesUtil.readValue("zkAgentPath");
		if (zkAgentPath.isEmpty()) {
			logger.error("the zkAgentPath is empty");
			throw new Exception("the zkAgentPath is empty");
		}
		return zkAgentPath;
	}

	class ElectorCallbacks implements ActiveStandbyElectorCallback {

		@Override
		public void becomeActive(String agentName) throws Exception {
			String zkAgentPath = getAgentBasePath();

			ZooKeeper zk = ZooKeeperSingleton.getInstance().getZk();

			Application application = null;

			EventBus eventBus = new EventBus(agentName + "-event-bus");
			List<LifecycleAware> components = Lists.newArrayList();
			String zkAddress = PropertiesUtil.readValue("zkAddress");
			PollingZooKeeperConfigurationProvider zookeeperConfigurationProvider = new PollingZooKeeperConfigurationProvider(
					agentName, zkAddress, zkAgentPath, eventBus);
			components.add(zookeeperConfigurationProvider);
			application = new Application(components);
			eventBus.register(application);

			application.start();

			add2zk(agentName);
			map.put(agentName, application);
		}

		@Override
		public void becomeStandby() {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterNeutralMode() {
			// TODO Auto-generated method stub

		}

		@Override
		public void notifyFatalError(String errorMessage) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fenceOldActive(byte[] oldActiveData) {
			// TODO Auto-generated method stub

		}

	}
}
