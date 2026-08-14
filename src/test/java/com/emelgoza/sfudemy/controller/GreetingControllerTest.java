package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingControllerTest {
  private static final String GREETING = "Hello Everyone!";

  @Autowired private GreetingController greetingController;

  @Test
  void testSayHello() {
    String response = greetingController.sayHello();
    assertEquals(GREETING, response);
  }
}
