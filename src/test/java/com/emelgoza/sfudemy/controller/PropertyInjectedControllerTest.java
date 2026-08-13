package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.emelgoza.sfudemy.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
  private static final String GREETING = "Hello Everyone!";

  PropertyInjectedController propertyInjectedController;

  @BeforeEach
  void setUp() {
    propertyInjectedController = new PropertyInjectedController();
    propertyInjectedController.greetingService = new GreetingServiceImpl();
  }

  @Test
  void sayHello() {
    String response = propertyInjectedController.sayHello();
    assertEquals(GREETING, response);
  }
}
