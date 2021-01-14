package com.example.consumer.service.impl;

import com.example.api.service.CostService;
import com.example.consumer.service.MainProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Async
public class MainProductServiceImpl implements MainProductService {
  @Reference(interfaceClass = CostService.class, loadbalance = "random", version = "1.2.0")
  CostService costService;

  @Override
  public Integer getCost(int a) {
    System.out.println("[LOG] Invoke ProductService#getCost");
    return costService.doubleItUp(a);
  }

  @Override
  public CompletableFuture<Integer> asyncGetCost(int a) throws InterruptedException {
    System.out.println("[ASYNC LOG] Invoke ProductService#getCost");
    Thread.sleep(3000);
    return CompletableFuture.completedFuture(costService.doubleItUp(a));
  }
}
