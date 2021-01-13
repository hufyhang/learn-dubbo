package com.example.consumer.controller;

import com.example.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping("/add")
  public String getCode() {
    return "该产品总共消费 ：" + productService.getCost(100);
  }
}
