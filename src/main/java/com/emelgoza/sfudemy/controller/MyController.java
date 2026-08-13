package com.emelgoza.sfudemy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MyController {

  public String sayHello() {
    log.info("Hello from MyController");
    return "Hello from MyController";
  }
}
