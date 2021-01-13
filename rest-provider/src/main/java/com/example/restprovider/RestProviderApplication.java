package com.example.restprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class RestProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestProviderApplication.class, args);
  }

}
