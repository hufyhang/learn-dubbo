package com.example.restprovider.controller;

import com.example.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
  @Autowired
  ProductService productService;

  @RequestMapping("/get")
  public String getCode() {
    return "该产品总共消费 ：" + productService.getCost(100);
  }

}
