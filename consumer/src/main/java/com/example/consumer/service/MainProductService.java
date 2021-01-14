package com.example.consumer.service;

import java.util.concurrent.CompletableFuture;

public interface MainProductService {
  /**
   * 获得总消费
   * @param a
   * @return
   */
  Integer getCost(int a);

  CompletableFuture<Integer> asyncGetCost(int a) throws InterruptedException;
}
