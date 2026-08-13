package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.emelgoza.sfudemy.service.GreetingServiceImpl;

class ConstructorInjectedControllerTest {
  private static final String GREETING = "Hello Everyone!";

  ConstructorInjectedController constructorInjectedController;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
  }

  @org.junit.jupiter.api.Test
  void sayHello() {
    String response = constructorInjectedController.sayHello();
    assertEquals(GREETING, response);
  }
}
