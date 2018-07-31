/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.flume.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-07-31")
public class KafkaSource implements org.apache.thrift.TBase<KafkaSource, KafkaSource._Fields>, java.io.Serializable, Cloneable, Comparable<KafkaSource> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KafkaSource");

  private static final org.apache.thrift.protocol.TField SERVERS_FIELD_DESC = new org.apache.thrift.protocol.TField("servers", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TOPICS_FIELD_DESC = new org.apache.thrift.protocol.TField("topics", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField GROUP_FIELD_DESC = new org.apache.thrift.protocol.TField("group", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TOPICS_REGEX_FIELD_DESC = new org.apache.thrift.protocol.TField("topicsRegex", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField BATCH_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("batchSize", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new KafkaSourceStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new KafkaSourceTupleSchemeFactory();

  public java.lang.String servers; // required
  public java.lang.String topics; // required
  public java.lang.String group; // required
  public java.lang.String topicsRegex; // optional
  public int batchSize; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SERVERS((short)1, "servers"),
    TOPICS((short)2, "topics"),
    GROUP((short)3, "group"),
    TOPICS_REGEX((short)4, "topicsRegex"),
    BATCH_SIZE((short)5, "batchSize");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SERVERS
          return SERVERS;
        case 2: // TOPICS
          return TOPICS;
        case 3: // GROUP
          return GROUP;
        case 4: // TOPICS_REGEX
          return TOPICS_REGEX;
        case 5: // BATCH_SIZE
          return BATCH_SIZE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BATCHSIZE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TOPICS_REGEX,_Fields.BATCH_SIZE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SERVERS, new org.apache.thrift.meta_data.FieldMetaData("servers", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOPICS, new org.apache.thrift.meta_data.FieldMetaData("topics", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GROUP, new org.apache.thrift.meta_data.FieldMetaData("group", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOPICS_REGEX, new org.apache.thrift.meta_data.FieldMetaData("topicsRegex", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BATCH_SIZE, new org.apache.thrift.meta_data.FieldMetaData("batchSize", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KafkaSource.class, metaDataMap);
  }

  public KafkaSource() {
  }

  public KafkaSource(
    java.lang.String servers,
    java.lang.String topics,
    java.lang.String group)
  {
    this();
    this.servers = servers;
    this.topics = topics;
    this.group = group;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KafkaSource(KafkaSource other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetServers()) {
      this.servers = other.servers;
    }
    if (other.isSetTopics()) {
      this.topics = other.topics;
    }
    if (other.isSetGroup()) {
      this.group = other.group;
    }
    if (other.isSetTopicsRegex()) {
      this.topicsRegex = other.topicsRegex;
    }
    this.batchSize = other.batchSize;
  }

  public KafkaSource deepCopy() {
    return new KafkaSource(this);
  }

  @Override
  public void clear() {
    this.servers = null;
    this.topics = null;
    this.group = null;
    this.topicsRegex = null;
    setBatchSizeIsSet(false);
    this.batchSize = 0;
  }

  public java.lang.String getServers() {
    return this.servers;
  }

  public KafkaSource setServers(java.lang.String servers) {
    this.servers = servers;
    return this;
  }

  public void unsetServers() {
    this.servers = null;
  }

  /** Returns true if field servers is set (has been assigned a value) and false otherwise */
  public boolean isSetServers() {
    return this.servers != null;
  }

  public void setServersIsSet(boolean value) {
    if (!value) {
      this.servers = null;
    }
  }

  public java.lang.String getTopics() {
    return this.topics;
  }

  public KafkaSource setTopics(java.lang.String topics) {
    this.topics = topics;
    return this;
  }

  public void unsetTopics() {
    this.topics = null;
  }

  /** Returns true if field topics is set (has been assigned a value) and false otherwise */
  public boolean isSetTopics() {
    return this.topics != null;
  }

  public void setTopicsIsSet(boolean value) {
    if (!value) {
      this.topics = null;
    }
  }

  public java.lang.String getGroup() {
    return this.group;
  }

  public KafkaSource setGroup(java.lang.String group) {
    this.group = group;
    return this;
  }

  public void unsetGroup() {
    this.group = null;
  }

  /** Returns true if field group is set (has been assigned a value) and false otherwise */
  public boolean isSetGroup() {
    return this.group != null;
  }

  public void setGroupIsSet(boolean value) {
    if (!value) {
      this.group = null;
    }
  }

  public java.lang.String getTopicsRegex() {
    return this.topicsRegex;
  }

  public KafkaSource setTopicsRegex(java.lang.String topicsRegex) {
    this.topicsRegex = topicsRegex;
    return this;
  }

  public void unsetTopicsRegex() {
    this.topicsRegex = null;
  }

  /** Returns true if field topicsRegex is set (has been assigned a value) and false otherwise */
  public boolean isSetTopicsRegex() {
    return this.topicsRegex != null;
  }

  public void setTopicsRegexIsSet(boolean value) {
    if (!value) {
      this.topicsRegex = null;
    }
  }

  public int getBatchSize() {
    return this.batchSize;
  }

  public KafkaSource setBatchSize(int batchSize) {
    this.batchSize = batchSize;
    setBatchSizeIsSet(true);
    return this;
  }

  public void unsetBatchSize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BATCHSIZE_ISSET_ID);
  }

  /** Returns true if field batchSize is set (has been assigned a value) and false otherwise */
  public boolean isSetBatchSize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BATCHSIZE_ISSET_ID);
  }

  public void setBatchSizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BATCHSIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SERVERS:
      if (value == null) {
        unsetServers();
      } else {
        setServers((java.lang.String)value);
      }
      break;

    case TOPICS:
      if (value == null) {
        unsetTopics();
      } else {
        setTopics((java.lang.String)value);
      }
      break;

    case GROUP:
      if (value == null) {
        unsetGroup();
      } else {
        setGroup((java.lang.String)value);
      }
      break;

    case TOPICS_REGEX:
      if (value == null) {
        unsetTopicsRegex();
      } else {
        setTopicsRegex((java.lang.String)value);
      }
      break;

    case BATCH_SIZE:
      if (value == null) {
        unsetBatchSize();
      } else {
        setBatchSize((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SERVERS:
      return getServers();

    case TOPICS:
      return getTopics();

    case GROUP:
      return getGroup();

    case TOPICS_REGEX:
      return getTopicsRegex();

    case BATCH_SIZE:
      return getBatchSize();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SERVERS:
      return isSetServers();
    case TOPICS:
      return isSetTopics();
    case GROUP:
      return isSetGroup();
    case TOPICS_REGEX:
      return isSetTopicsRegex();
    case BATCH_SIZE:
      return isSetBatchSize();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof KafkaSource)
      return this.equals((KafkaSource)that);
    return false;
  }

  public boolean equals(KafkaSource that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_servers = true && this.isSetServers();
    boolean that_present_servers = true && that.isSetServers();
    if (this_present_servers || that_present_servers) {
      if (!(this_present_servers && that_present_servers))
        return false;
      if (!this.servers.equals(that.servers))
        return false;
    }

    boolean this_present_topics = true && this.isSetTopics();
    boolean that_present_topics = true && that.isSetTopics();
    if (this_present_topics || that_present_topics) {
      if (!(this_present_topics && that_present_topics))
        return false;
      if (!this.topics.equals(that.topics))
        return false;
    }

    boolean this_present_group = true && this.isSetGroup();
    boolean that_present_group = true && that.isSetGroup();
    if (this_present_group || that_present_group) {
      if (!(this_present_group && that_present_group))
        return false;
      if (!this.group.equals(that.group))
        return false;
    }

    boolean this_present_topicsRegex = true && this.isSetTopicsRegex();
    boolean that_present_topicsRegex = true && that.isSetTopicsRegex();
    if (this_present_topicsRegex || that_present_topicsRegex) {
      if (!(this_present_topicsRegex && that_present_topicsRegex))
        return false;
      if (!this.topicsRegex.equals(that.topicsRegex))
        return false;
    }

    boolean this_present_batchSize = true && this.isSetBatchSize();
    boolean that_present_batchSize = true && that.isSetBatchSize();
    if (this_present_batchSize || that_present_batchSize) {
      if (!(this_present_batchSize && that_present_batchSize))
        return false;
      if (this.batchSize != that.batchSize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetServers()) ? 131071 : 524287);
    if (isSetServers())
      hashCode = hashCode * 8191 + servers.hashCode();

    hashCode = hashCode * 8191 + ((isSetTopics()) ? 131071 : 524287);
    if (isSetTopics())
      hashCode = hashCode * 8191 + topics.hashCode();

    hashCode = hashCode * 8191 + ((isSetGroup()) ? 131071 : 524287);
    if (isSetGroup())
      hashCode = hashCode * 8191 + group.hashCode();

    hashCode = hashCode * 8191 + ((isSetTopicsRegex()) ? 131071 : 524287);
    if (isSetTopicsRegex())
      hashCode = hashCode * 8191 + topicsRegex.hashCode();

    hashCode = hashCode * 8191 + ((isSetBatchSize()) ? 131071 : 524287);
    if (isSetBatchSize())
      hashCode = hashCode * 8191 + batchSize;

    return hashCode;
  }

  @Override
  public int compareTo(KafkaSource other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetServers()).compareTo(other.isSetServers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.servers, other.servers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTopics()).compareTo(other.isSetTopics());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTopics()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topics, other.topics);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetGroup()).compareTo(other.isSetGroup());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroup()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.group, other.group);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTopicsRegex()).compareTo(other.isSetTopicsRegex());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTopicsRegex()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topicsRegex, other.topicsRegex);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBatchSize()).compareTo(other.isSetBatchSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBatchSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.batchSize, other.batchSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("KafkaSource(");
    boolean first = true;

    sb.append("servers:");
    if (this.servers == null) {
      sb.append("null");
    } else {
      sb.append(this.servers);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("topics:");
    if (this.topics == null) {
      sb.append("null");
    } else {
      sb.append(this.topics);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("group:");
    if (this.group == null) {
      sb.append("null");
    } else {
      sb.append(this.group);
    }
    first = false;
    if (isSetTopicsRegex()) {
      if (!first) sb.append(", ");
      sb.append("topicsRegex:");
      if (this.topicsRegex == null) {
        sb.append("null");
      } else {
        sb.append(this.topicsRegex);
      }
      first = false;
    }
    if (isSetBatchSize()) {
      if (!first) sb.append(", ");
      sb.append("batchSize:");
      sb.append(this.batchSize);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (servers == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'servers' was not present! Struct: " + toString());
    }
    if (topics == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'topics' was not present! Struct: " + toString());
    }
    if (group == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'group' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class KafkaSourceStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaSourceStandardScheme getScheme() {
      return new KafkaSourceStandardScheme();
    }
  }

  private static class KafkaSourceStandardScheme extends org.apache.thrift.scheme.StandardScheme<KafkaSource> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KafkaSource struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SERVERS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.servers = iprot.readString();
              struct.setServersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TOPICS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.topics = iprot.readString();
              struct.setTopicsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GROUP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.group = iprot.readString();
              struct.setGroupIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOPICS_REGEX
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.topicsRegex = iprot.readString();
              struct.setTopicsRegexIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BATCH_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.batchSize = iprot.readI32();
              struct.setBatchSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, KafkaSource struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.servers != null) {
        oprot.writeFieldBegin(SERVERS_FIELD_DESC);
        oprot.writeString(struct.servers);
        oprot.writeFieldEnd();
      }
      if (struct.topics != null) {
        oprot.writeFieldBegin(TOPICS_FIELD_DESC);
        oprot.writeString(struct.topics);
        oprot.writeFieldEnd();
      }
      if (struct.group != null) {
        oprot.writeFieldBegin(GROUP_FIELD_DESC);
        oprot.writeString(struct.group);
        oprot.writeFieldEnd();
      }
      if (struct.topicsRegex != null) {
        if (struct.isSetTopicsRegex()) {
          oprot.writeFieldBegin(TOPICS_REGEX_FIELD_DESC);
          oprot.writeString(struct.topicsRegex);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetBatchSize()) {
        oprot.writeFieldBegin(BATCH_SIZE_FIELD_DESC);
        oprot.writeI32(struct.batchSize);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KafkaSourceTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaSourceTupleScheme getScheme() {
      return new KafkaSourceTupleScheme();
    }
  }

  private static class KafkaSourceTupleScheme extends org.apache.thrift.scheme.TupleScheme<KafkaSource> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KafkaSource struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.servers);
      oprot.writeString(struct.topics);
      oprot.writeString(struct.group);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTopicsRegex()) {
        optionals.set(0);
      }
      if (struct.isSetBatchSize()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTopicsRegex()) {
        oprot.writeString(struct.topicsRegex);
      }
      if (struct.isSetBatchSize()) {
        oprot.writeI32(struct.batchSize);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KafkaSource struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.servers = iprot.readString();
      struct.setServersIsSet(true);
      struct.topics = iprot.readString();
      struct.setTopicsIsSet(true);
      struct.group = iprot.readString();
      struct.setGroupIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.topicsRegex = iprot.readString();
        struct.setTopicsRegexIsSet(true);
      }
      if (incoming.get(1)) {
        struct.batchSize = iprot.readI32();
        struct.setBatchSizeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

