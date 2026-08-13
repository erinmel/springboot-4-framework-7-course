package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;
import com.emelgoza.sfudemy.service.GreetingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class GreetingController {

  private final GreetingService greetingService;

  public GreetingController() {
    this.greetingService = new GreetingServiceImpl();
  }

  public String sayHello() {
    log.info("Hello from MyController");
    return greetingService.sayGreeting();
  }
}
