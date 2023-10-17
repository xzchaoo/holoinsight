/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.gateway.core.grpc;

import java.util.List;
import java.util.Map;

import io.holoinsight.server.common.auth.AuthInfo;
import io.holoinsight.server.gateway.grpc.WriteMetricsRequestV1;
import io.holoinsight.server.gateway.grpc.WriteMetricsRequestV4;

/**
 * <p>
 * created at 2023/9/18
 *
 * @author xzchaoo
 */
public interface GatewayHook {
  /**
   * writeMetricsV1 hook
   * 
   * @param authInfo
   * @param request
   */
  void writeMetricsV1(AuthInfo authInfo, WriteMetricsRequestV1 request);

  /**
   * writeMetricsV4 hook
   *
   * @param authInfo
   * @param request
   */
  void writeMetricsV4(AuthInfo authInfo, WriteMetricsRequestV4 request);

  void writeDetail(AuthInfo authInfo, List<Data> request);

  @lombok.Data
  class Data {
    private String name;
    private long timestamp;
    private Map<String, String> tags;
    private Map<String, Double> fields;
  }

  @lombok.Data
  class Table {
    private String name;
    private long timestamp;
  }

  @lombok.Data
  class Header {
    private List<String> tagKeys;
    private List<String> fieldKeys;
  }

  @lombok.Data
  class Row {
    private List<String> tagValues;
    // TODO
    private List<Double> fieldValues;
  }
}
