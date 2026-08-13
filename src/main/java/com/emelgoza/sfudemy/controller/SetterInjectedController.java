package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;

public class SetterInjectedController {
  private GreetingService greetingService;

  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
