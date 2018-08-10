/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.flume.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-08-10")
public class FlumeSink implements org.apache.thrift.TBase<FlumeSink, FlumeSink._Fields>, java.io.Serializable, Cloneable, Comparable<FlumeSink> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FlumeSink");

  private static final org.apache.thrift.protocol.TField SINK_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("SinkType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField HDFS_SINK_FIELD_DESC = new org.apache.thrift.protocol.TField("hdfsSink", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField ES_SINK_FIELD_DESC = new org.apache.thrift.protocol.TField("esSink", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField KAFKA_SINK_FIELD_DESC = new org.apache.thrift.protocol.TField("kafkaSink", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FlumeSinkStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FlumeSinkTupleSchemeFactory();

  /**
   * 
   * @see SinkType
   */
  public SinkType SinkType; // required
  public HDFSSink hdfsSink; // optional
  public ESSink esSink; // optional
  public KafkaSink kafkaSink; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see SinkType
     */
    SINK_TYPE((short)1, "SinkType"),
    HDFS_SINK((short)2, "hdfsSink"),
    ES_SINK((short)3, "esSink"),
    KAFKA_SINK((short)4, "kafkaSink");

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
        case 1: // SINK_TYPE
          return SINK_TYPE;
        case 2: // HDFS_SINK
          return HDFS_SINK;
        case 3: // ES_SINK
          return ES_SINK;
        case 4: // KAFKA_SINK
          return KAFKA_SINK;
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
  private static final _Fields optionals[] = {_Fields.HDFS_SINK,_Fields.ES_SINK,_Fields.KAFKA_SINK};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SINK_TYPE, new org.apache.thrift.meta_data.FieldMetaData("SinkType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SinkType.class)));
    tmpMap.put(_Fields.HDFS_SINK, new org.apache.thrift.meta_data.FieldMetaData("hdfsSink", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HDFSSink.class)));
    tmpMap.put(_Fields.ES_SINK, new org.apache.thrift.meta_data.FieldMetaData("esSink", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ESSink.class)));
    tmpMap.put(_Fields.KAFKA_SINK, new org.apache.thrift.meta_data.FieldMetaData("kafkaSink", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, KafkaSink.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FlumeSink.class, metaDataMap);
  }

  public FlumeSink() {
  }

  public FlumeSink(
    SinkType SinkType)
  {
    this();
    this.SinkType = SinkType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FlumeSink(FlumeSink other) {
    if (other.isSetSinkType()) {
      this.SinkType = other.SinkType;
    }
    if (other.isSetHdfsSink()) {
      this.hdfsSink = new HDFSSink(other.hdfsSink);
    }
    if (other.isSetEsSink()) {
      this.esSink = new ESSink(other.esSink);
    }
    if (other.isSetKafkaSink()) {
      this.kafkaSink = new KafkaSink(other.kafkaSink);
    }
  }

  public FlumeSink deepCopy() {
    return new FlumeSink(this);
  }

  @Override
  public void clear() {
    this.SinkType = null;
    this.hdfsSink = null;
    this.esSink = null;
    this.kafkaSink = null;
  }

  /**
   * 
   * @see SinkType
   */
  public SinkType getSinkType() {
    return this.SinkType;
  }

  /**
   * 
   * @see SinkType
   */
  public FlumeSink setSinkType(SinkType SinkType) {
    this.SinkType = SinkType;
    return this;
  }

  public void unsetSinkType() {
    this.SinkType = null;
  }

  /** Returns true if field SinkType is set (has been assigned a value) and false otherwise */
  public boolean isSetSinkType() {
    return this.SinkType != null;
  }

  public void setSinkTypeIsSet(boolean value) {
    if (!value) {
      this.SinkType = null;
    }
  }

  public HDFSSink getHdfsSink() {
    return this.hdfsSink;
  }

  public FlumeSink setHdfsSink(HDFSSink hdfsSink) {
    this.hdfsSink = hdfsSink;
    return this;
  }

  public void unsetHdfsSink() {
    this.hdfsSink = null;
  }

  /** Returns true if field hdfsSink is set (has been assigned a value) and false otherwise */
  public boolean isSetHdfsSink() {
    return this.hdfsSink != null;
  }

  public void setHdfsSinkIsSet(boolean value) {
    if (!value) {
      this.hdfsSink = null;
    }
  }

  public ESSink getEsSink() {
    return this.esSink;
  }

  public FlumeSink setEsSink(ESSink esSink) {
    this.esSink = esSink;
    return this;
  }

  public void unsetEsSink() {
    this.esSink = null;
  }

  /** Returns true if field esSink is set (has been assigned a value) and false otherwise */
  public boolean isSetEsSink() {
    return this.esSink != null;
  }

  public void setEsSinkIsSet(boolean value) {
    if (!value) {
      this.esSink = null;
    }
  }

  public KafkaSink getKafkaSink() {
    return this.kafkaSink;
  }

  public FlumeSink setKafkaSink(KafkaSink kafkaSink) {
    this.kafkaSink = kafkaSink;
    return this;
  }

  public void unsetKafkaSink() {
    this.kafkaSink = null;
  }

  /** Returns true if field kafkaSink is set (has been assigned a value) and false otherwise */
  public boolean isSetKafkaSink() {
    return this.kafkaSink != null;
  }

  public void setKafkaSinkIsSet(boolean value) {
    if (!value) {
      this.kafkaSink = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SINK_TYPE:
      if (value == null) {
        unsetSinkType();
      } else {
        setSinkType((SinkType)value);
      }
      break;

    case HDFS_SINK:
      if (value == null) {
        unsetHdfsSink();
      } else {
        setHdfsSink((HDFSSink)value);
      }
      break;

    case ES_SINK:
      if (value == null) {
        unsetEsSink();
      } else {
        setEsSink((ESSink)value);
      }
      break;

    case KAFKA_SINK:
      if (value == null) {
        unsetKafkaSink();
      } else {
        setKafkaSink((KafkaSink)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SINK_TYPE:
      return getSinkType();

    case HDFS_SINK:
      return getHdfsSink();

    case ES_SINK:
      return getEsSink();

    case KAFKA_SINK:
      return getKafkaSink();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SINK_TYPE:
      return isSetSinkType();
    case HDFS_SINK:
      return isSetHdfsSink();
    case ES_SINK:
      return isSetEsSink();
    case KAFKA_SINK:
      return isSetKafkaSink();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof FlumeSink)
      return this.equals((FlumeSink)that);
    return false;
  }

  public boolean equals(FlumeSink that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_SinkType = true && this.isSetSinkType();
    boolean that_present_SinkType = true && that.isSetSinkType();
    if (this_present_SinkType || that_present_SinkType) {
      if (!(this_present_SinkType && that_present_SinkType))
        return false;
      if (!this.SinkType.equals(that.SinkType))
        return false;
    }

    boolean this_present_hdfsSink = true && this.isSetHdfsSink();
    boolean that_present_hdfsSink = true && that.isSetHdfsSink();
    if (this_present_hdfsSink || that_present_hdfsSink) {
      if (!(this_present_hdfsSink && that_present_hdfsSink))
        return false;
      if (!this.hdfsSink.equals(that.hdfsSink))
        return false;
    }

    boolean this_present_esSink = true && this.isSetEsSink();
    boolean that_present_esSink = true && that.isSetEsSink();
    if (this_present_esSink || that_present_esSink) {
      if (!(this_present_esSink && that_present_esSink))
        return false;
      if (!this.esSink.equals(that.esSink))
        return false;
    }

    boolean this_present_kafkaSink = true && this.isSetKafkaSink();
    boolean that_present_kafkaSink = true && that.isSetKafkaSink();
    if (this_present_kafkaSink || that_present_kafkaSink) {
      if (!(this_present_kafkaSink && that_present_kafkaSink))
        return false;
      if (!this.kafkaSink.equals(that.kafkaSink))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSinkType()) ? 131071 : 524287);
    if (isSetSinkType())
      hashCode = hashCode * 8191 + SinkType.getValue();

    hashCode = hashCode * 8191 + ((isSetHdfsSink()) ? 131071 : 524287);
    if (isSetHdfsSink())
      hashCode = hashCode * 8191 + hdfsSink.hashCode();

    hashCode = hashCode * 8191 + ((isSetEsSink()) ? 131071 : 524287);
    if (isSetEsSink())
      hashCode = hashCode * 8191 + esSink.hashCode();

    hashCode = hashCode * 8191 + ((isSetKafkaSink()) ? 131071 : 524287);
    if (isSetKafkaSink())
      hashCode = hashCode * 8191 + kafkaSink.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(FlumeSink other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetSinkType()).compareTo(other.isSetSinkType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinkType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.SinkType, other.SinkType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHdfsSink()).compareTo(other.isSetHdfsSink());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHdfsSink()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hdfsSink, other.hdfsSink);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEsSink()).compareTo(other.isSetEsSink());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEsSink()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.esSink, other.esSink);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetKafkaSink()).compareTo(other.isSetKafkaSink());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKafkaSink()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kafkaSink, other.kafkaSink);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FlumeSink(");
    boolean first = true;

    sb.append("SinkType:");
    if (this.SinkType == null) {
      sb.append("null");
    } else {
      sb.append(this.SinkType);
    }
    first = false;
    if (isSetHdfsSink()) {
      if (!first) sb.append(", ");
      sb.append("hdfsSink:");
      if (this.hdfsSink == null) {
        sb.append("null");
      } else {
        sb.append(this.hdfsSink);
      }
      first = false;
    }
    if (isSetEsSink()) {
      if (!first) sb.append(", ");
      sb.append("esSink:");
      if (this.esSink == null) {
        sb.append("null");
      } else {
        sb.append(this.esSink);
      }
      first = false;
    }
    if (isSetKafkaSink()) {
      if (!first) sb.append(", ");
      sb.append("kafkaSink:");
      if (this.kafkaSink == null) {
        sb.append("null");
      } else {
        sb.append(this.kafkaSink);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (SinkType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'SinkType' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (hdfsSink != null) {
      hdfsSink.validate();
    }
    if (esSink != null) {
      esSink.validate();
    }
    if (kafkaSink != null) {
      kafkaSink.validate();
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FlumeSinkStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FlumeSinkStandardScheme getScheme() {
      return new FlumeSinkStandardScheme();
    }
  }

  private static class FlumeSinkStandardScheme extends org.apache.thrift.scheme.StandardScheme<FlumeSink> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FlumeSink struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SINK_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.SinkType = org.apache.flume.service.SinkType.findByValue(iprot.readI32());
              struct.setSinkTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HDFS_SINK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.hdfsSink = new HDFSSink();
              struct.hdfsSink.read(iprot);
              struct.setHdfsSinkIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ES_SINK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.esSink = new ESSink();
              struct.esSink.read(iprot);
              struct.setEsSinkIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // KAFKA_SINK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.kafkaSink = new KafkaSink();
              struct.kafkaSink.read(iprot);
              struct.setKafkaSinkIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FlumeSink struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.SinkType != null) {
        oprot.writeFieldBegin(SINK_TYPE_FIELD_DESC);
        oprot.writeI32(struct.SinkType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.hdfsSink != null) {
        if (struct.isSetHdfsSink()) {
          oprot.writeFieldBegin(HDFS_SINK_FIELD_DESC);
          struct.hdfsSink.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.esSink != null) {
        if (struct.isSetEsSink()) {
          oprot.writeFieldBegin(ES_SINK_FIELD_DESC);
          struct.esSink.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.kafkaSink != null) {
        if (struct.isSetKafkaSink()) {
          oprot.writeFieldBegin(KAFKA_SINK_FIELD_DESC);
          struct.kafkaSink.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FlumeSinkTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FlumeSinkTupleScheme getScheme() {
      return new FlumeSinkTupleScheme();
    }
  }

  private static class FlumeSinkTupleScheme extends org.apache.thrift.scheme.TupleScheme<FlumeSink> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FlumeSink struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.SinkType.getValue());
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetHdfsSink()) {
        optionals.set(0);
      }
      if (struct.isSetEsSink()) {
        optionals.set(1);
      }
      if (struct.isSetKafkaSink()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetHdfsSink()) {
        struct.hdfsSink.write(oprot);
      }
      if (struct.isSetEsSink()) {
        struct.esSink.write(oprot);
      }
      if (struct.isSetKafkaSink()) {
        struct.kafkaSink.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FlumeSink struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.SinkType = org.apache.flume.service.SinkType.findByValue(iprot.readI32());
      struct.setSinkTypeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.hdfsSink = new HDFSSink();
        struct.hdfsSink.read(iprot);
        struct.setHdfsSinkIsSet(true);
      }
      if (incoming.get(1)) {
        struct.esSink = new ESSink();
        struct.esSink.read(iprot);
        struct.setEsSinkIsSet(true);
      }
      if (incoming.get(2)) {
        struct.kafkaSink = new KafkaSink();
        struct.kafkaSink.read(iprot);
        struct.setKafkaSinkIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

