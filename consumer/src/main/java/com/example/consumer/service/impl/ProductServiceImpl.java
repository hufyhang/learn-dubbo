package com.example.consumer.service.impl;

import com.example.api.service.CostService;
import com.example.consumer.service.ProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Reference(interfaceClass = CostService.class, loadbalance = "random", version = "1.2.0")
  CostService costService;

  @Override
  public Integer getCost(int a) {
    return costService.doubleItUp(a);
  }
}
