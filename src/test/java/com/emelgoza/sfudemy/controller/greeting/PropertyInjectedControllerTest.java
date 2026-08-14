package com.emelgoza.sfudemy.controller.greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("EN")
@SpringBootTest
class PropertyInjectedControllerTest {
  private static final String GREETING =
      "Friends don't let friends to property inject dependencies!";

  @Autowired private PropertyInjectedController propertyInjectedController;

  @Test
  void sayHello() {
    String response = propertyInjectedController.sayHello();
    assertEquals(GREETING, response);
  }
}
