package com.example.restprovider.controller;

import com.example.consumer.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value="Basic RESTful API")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
  @Autowired
  ProductService productService;

  @ApiOperation(value = "获取产品总消费信息")
  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String getCode() {
    System.out.println("========================");
    System.out.println("CHECK API CALLING");
    System.out.println("========================");
    return "该产品总共消费 ：" + productService.getCost(100);
  }

}
