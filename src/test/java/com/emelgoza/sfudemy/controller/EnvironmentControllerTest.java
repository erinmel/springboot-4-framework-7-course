package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class EnvironmentControllerTest {

  void assertEnvironment(EnvironmentController controller, String expectedEnvironment) {
    assertEquals("The current environment is: " + expectedEnvironment, controller.getEnvironment());
  }

  @Nested
  @ActiveProfiles("dev")
  class WhenDevEnvironment {
    @Autowired EnvironmentController environmentController;

    @Test
    void testEnvironment() {
      assertEnvironment(environmentController, "dev");
    }
  }

  @Nested
  @ActiveProfiles("prod")
  class WhenProdEnvironment {
    @Autowired EnvironmentController environmentController;

    @Test
    void testEnvironment() {
      assertEnvironment(environmentController, "prod");
    }
  }

  @Nested
  @ActiveProfiles("qa")
  class WhenQaEnvironment {
    @Autowired EnvironmentController environmentController;

    @Test
    void testEnvironment() {
      assertEnvironment(environmentController, "qa");
    }
  }
}
