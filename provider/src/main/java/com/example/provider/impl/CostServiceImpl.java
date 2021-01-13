package com.example.provider.impl;

import com.example.api.service.CostService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service(interfaceClass = CostService.class, protocol = "dubbo", version = "1.2.0")
@Component
public class CostServiceImpl implements CostService {
  @Override
  public Integer addNumber(int cost) {
    return cost + cost;
  }
}
