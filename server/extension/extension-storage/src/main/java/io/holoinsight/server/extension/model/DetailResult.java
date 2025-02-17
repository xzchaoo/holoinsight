/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.extension.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masaimu
 * @date 2023/8/11
 */
@Data
public class DetailResult {

  List<String> tables;
  String sql;
  List<String> headers;
  List<DetailRow> points;

  public static DetailResult empty() {
    return new DetailResult();
  }

  public boolean isEmpty() {
    return this.points == null || this.points.size() == 0;
  }

  public void add(DetailRow detailRow) {
    if (points == null) {
      points = new ArrayList<>();
    }
    points.add(detailRow);
  }

  @Data
  public static class DetailRow {
    List<Value> values = new ArrayList<>();

    public void addStringValue(String string) {
      Value value = new Value(DetailDataType.String, string);
      values.add(value);
    }

    public void addTimestampValue(long timestamp) {
      Value value = new Value(DetailDataType.Timestamp, timestamp);
      values.add(value);
    }

    public void addBooleanValue(boolean aBoolean) {
      Value value = new Value(DetailDataType.Boolean, aBoolean);
      values.add(value);
    }

    public void addNumValue(Object object) {
      if (object instanceof Number) {
        Value value = new Value(DetailDataType.Double, ((Number) object).doubleValue());
        values.add(value);
      }
    }
  }

  @Data
  public static class Value {
    private final DetailDataType type;
    private final Object value;
  }

  public enum DetailDataType {
    String(String.class), //
    Boolean(Boolean.class), //
    Double(Double.class), //
    Timestamp(Long.class); //

    private final Class<?> javaType;

    DetailDataType(Class<?> javaType) {
      this.javaType = javaType;
    }

    public Class<?> getJavaType() {
      return javaType;
    }
  }

}
