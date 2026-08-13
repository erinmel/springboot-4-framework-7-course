package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;

// Preferred way of injecting dependencies, recommended
public class ConstructorInjectedController {
  private final GreetingService greetingService;

  public ConstructorInjectedController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
