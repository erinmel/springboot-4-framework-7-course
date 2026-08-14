package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConstructorInjectedControllerTest {
  private static final String GREETING = "Hello Everyone!";

  @Autowired private ConstructorInjectedController constructorInjectedController;

  @Test
  void sayHello() {
    String response = constructorInjectedController.sayHello();
    assertEquals(GREETING, response);
  }
}
