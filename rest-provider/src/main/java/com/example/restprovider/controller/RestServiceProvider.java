package com.example.restprovider.controller;

import com.example.consumer.service.MainProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Api(value="Basic RESTful API")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestServiceProvider {
  @Autowired
  MainProductService productService;

  @ApiOperation(value = "获取产品总消费信息")
  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String getCode() {
    System.out.println("========================");
    System.out.println("CHECK API CALLING");
    System.out.println("========================");
    return "该产品总共消费 ：" + productService.getCost(100);
  }


  @RequestMapping(value = "/async", method = RequestMethod.GET)
  public String asyncGetCode() {
    System.out.println("========================");
    System.out.println("CHECK ASYNC API CALLING");
    System.out.println("========================");

    int[] costList = new int[]{1000, 2000, 100, 80, 90};
    CompletableFuture<Integer>[] taskList = new CompletableFuture[costList.length];

    try {
      for (int index = 0; index != costList.length; ++index) {
        taskList[index] = productService.asyncGetCost(costList[index]);
      }
    } catch (InterruptedException exp) {
      exp.printStackTrace();
    }

    CompletableFuture.allOf(taskList).join();
    StringBuffer buffer = new StringBuffer();
    for (CompletableFuture<Integer>task : taskList) {
      try {
        buffer.append("==> ASYNC COST: " + task.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    return buffer.toString();
  }

}
