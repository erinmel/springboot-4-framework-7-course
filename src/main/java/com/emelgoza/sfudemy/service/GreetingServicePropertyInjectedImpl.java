package com.emelgoza.sfudemy.service;

import org.springframework.stereotype.Service;

@Service("propertyInjectedGreetingService")
public class GreetingServicePropertyInjectedImpl implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Friends don't let friends to property inject dependencies!";
  }
}
