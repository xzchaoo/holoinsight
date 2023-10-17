/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.agg.v1.executor.executor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import io.holoinsight.server.agg.v1.core.conf.AggFunc;
import io.holoinsight.server.agg.v1.pb.AggProtos;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * created at 2023/9/27
 *
 * @author xzchaoo
 */
public class TopnState {
  private static final Comparator<CostItem> ASC = Comparator.comparingDouble(CostItem::getCost);
  private static final Comparator<CostItem> DESC = ASC.reversed();

  private final AggFunc.TopnParams params;
  private final PriorityQueue<CostItem> q;
  private final Comparator<CostItem> comparator;
  private final DoubleComparator costComparator;

  public TopnState(AggFunc.TopnParams params) {
    this.params = Objects.requireNonNull(params);
    if (params.isDesc()) {
      comparator = ASC;
      costComparator = Double::compare;
    } else {
      comparator = DESC;
      costComparator = (a, b) -> Double.compare(b, a);
    }
    q = new PriorityQueue<>(comparator);
  }

  public static TopnState fromDTO(AggFunc aggFunc, DTO dto) {
    TopnState state = new TopnState(aggFunc.getTopn());
    for (CostItem ci : dto.getList()) {
      state.add(ci);
    }
    return state;
  }

  public void add(AggProtos.InDataNode in, BasicFieldAccessors.Accessor accessor) {
    double value = accessor.float64();

    if (q.size() > 0 && q.size() == params.getLimit()
        && costComparator.compare(value, q.peek().cost) <= 0) {
      return;
    }

    Map<String, Object> obj = new HashMap<>();
    obj.put("tags", in.getTagsMap());
    obj.put("value", value);

    q.add(new CostItem(value, obj));
    if (q.size() > params.getLimit()) {
      q.poll();
    }
  }

  private void add(CostItem in) {
    double value = in.cost;

    if (q.size() > 0 && q.size() == params.getLimit()
        && costComparator.compare(value, q.peek().cost) <= 0) {
      return;
    }

    q.add(in);
    if (q.size() > params.getLimit()) {
      q.poll();
    }
  }

  public DTO toDTO() {
    DTO dto = new DTO();
    dto.setList(new ArrayList<>(q));
    return dto;
  }

  public Object getFinalValue() {
    return q.stream() //
        .sorted(comparator.reversed()) //
        .map(x -> x.item) //
        .collect(Collectors.toList()); //
  }

  @FunctionalInterface
  private interface DoubleComparator {
    int compare(double v1, double v2);
  }

  @Data
  public static class DTO {
    private List<CostItem> list;
  }

  @AllArgsConstructor
  @Data
  public static class CostItem {
    final double cost;
    final Object item;
  }

}
