package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  @SuppressWarnings({"java:S6813"})
  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
