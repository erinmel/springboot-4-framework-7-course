package com.emelgoza.sfudemy.controller.greeting;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  // suppres autowired should not be used
  @SuppressWarnings({"java:S6813"})
  @Qualifier("propertyInjectedGreetingService")
  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
