package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingControllerTest {
  private static final String GREETING = "Hello Everyone!";

  @Test
  void testSayHello() {
    GreetingController greetingController = new GreetingController();
    String response = greetingController.sayHello();
    assertEquals(GREETING, response);
  }
}
