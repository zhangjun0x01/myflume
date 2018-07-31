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

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.flume.lifecycle.LifecycleAware;
import org.apache.flume.node.Application;
import org.apache.flume.node.PollingZooKeeperConfigurationProvider;
import org.apache.flume.service.FlumeControllerService.Iface;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

public class FlumeControllerServiceImpl implements Iface {
	private static final Logger logger = LoggerFactory.getLogger(FlumeControllerServiceImpl.class);
	private ConcurrentHashMap<String, Application> map = new ConcurrentHashMap<String, Application>();

	@Override
	public Status startFlumeAgent(String agentName, FlumeAgent agent) throws TException {

		try {
			boolean res = geneConfToZK(agentName,agent);
			Application application = null;
			// get options
			String zkConnectionStr = "localhost:2181";
			String baseZkPath = "/flume";

			EventBus eventBus = new EventBus(agentName + "-event-bus");
			List<LifecycleAware> components = Lists.newArrayList();
			PollingZooKeeperConfigurationProvider zookeeperConfigurationProvider = new PollingZooKeeperConfigurationProvider(agentName, zkConnectionStr,
					baseZkPath, eventBus);
			components.add(zookeeperConfigurationProvider);
			application = new Application(components);
			eventBus.register(application);

			application.start();

			map.put(agentName, application);

			final Application appReference = application;
			Runtime.getRuntime().addShutdownHook(new Thread("agent-shutdown-hook") {
				@Override
				public void run() {
					appReference.stop();
				}
			});

		} catch (Exception e) {
			logger.error("A fatal error occurred while running. Exception follows.", e);
		}

		return Status.OK;
	}

	/**
	 * 将传过来的对象生成flume的配置模板，然后放到zk相应的位置
	 * @param agentName
	 * @param agent
	 * @return
	 */
	private boolean geneConfToZK(String agentName, FlumeAgent agent) {
	
		
		
		return false;
	}

	@Override
	public Status stopFlumeAgent(String agentName) throws TException {
		if (map.get(agentName) != null) {
			map.get(agentName).stop();
		}
		return Status.OK;
	}

	@Override
	public Status modifyConf(String name, FlumeAgent agent) throws TException {
	
		return null;
	}

}
