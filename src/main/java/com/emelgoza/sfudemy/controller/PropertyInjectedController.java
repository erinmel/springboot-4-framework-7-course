package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;

// Least Preferred way of injecting dependencies, not recommended
public class PropertyInjectedController {

  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
