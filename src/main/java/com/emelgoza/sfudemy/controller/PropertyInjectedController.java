package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.GreetingService;

public class PropertyInjectedController {

  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
