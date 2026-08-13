package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;

// Better than property injection, but still not the best way of injecting dependencies, can throw
// NullPointerException if the setter is not called, so it is not recommended
public class SetterInjectedController {
  private GreetingService greetingService;

  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
