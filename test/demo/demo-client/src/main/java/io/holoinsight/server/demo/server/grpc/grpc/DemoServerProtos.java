// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: demo-server.proto

package io.holoinsight.server.demo.server.grpc;

public final class DemoServerProtos {
  private DemoServerProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_holoinsight_server_demo_server_FooRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_holoinsight_server_demo_server_FooRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_holoinsight_server_demo_server_FooResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_holoinsight_server_demo_server_FooResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_holoinsight_server_demo_server_BarRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_holoinsight_server_demo_server_BarRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_holoinsight_server_demo_server_BarResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_holoinsight_server_demo_server_BarResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021demo-server.proto\022!io.holoinsight.serv" +
      "er.demo.server\"\027\n\nFooRequest\022\t\n\001a\030\001 \001(\005\"" +
      "\030\n\013FooResponse\022\t\n\001a\030\001 \001(\005\"\027\n\nBarRequest\022" +
      "\t\n\001a\030\001 \001(\005\"\030\n\013BarResponse\022\t\n\001a\030\001 \001(\0052\335\001\n" +
      "\013DemoService\022f\n\003foo\022-.io.holoinsight.ser" +
      "ver.demo.server.FooRequest\032..io.holoinsi" +
      "ght.server.demo.server.FooResponse\"\000\022f\n\003" +
      "bar\022-.io.holoinsight.server.demo.server." +
      "BarRequest\032..io.holoinsight.server.demo." +
      "server.BarResponse\"\000B<\n&io.holoinsight.s" +
      "erver.demo.server.grpcB\020DemoServerProtos" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_io_holoinsight_server_demo_server_FooRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_holoinsight_server_demo_server_FooRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_holoinsight_server_demo_server_FooRequest_descriptor,
        new java.lang.String[] { "A", });
    internal_static_io_holoinsight_server_demo_server_FooResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_io_holoinsight_server_demo_server_FooResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_holoinsight_server_demo_server_FooResponse_descriptor,
        new java.lang.String[] { "A", });
    internal_static_io_holoinsight_server_demo_server_BarRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_io_holoinsight_server_demo_server_BarRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_holoinsight_server_demo_server_BarRequest_descriptor,
        new java.lang.String[] { "A", });
    internal_static_io_holoinsight_server_demo_server_BarResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_io_holoinsight_server_demo_server_BarResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_holoinsight_server_demo_server_BarResponse_descriptor,
        new java.lang.String[] { "A", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
