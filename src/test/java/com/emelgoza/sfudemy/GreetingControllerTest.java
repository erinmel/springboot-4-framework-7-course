package com.emelgoza.sfudemy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.emelgoza.sfudemy.controller.GreetingController;
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
