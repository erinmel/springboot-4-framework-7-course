package com.emelgoza.sfudemy.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.emelgoza.sfudemy.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {
  private static final String GREETING = "Hello Everyone!";

  SetterInjectedController setterInjectedController;

  @BeforeEach
  void setUp() {
    setterInjectedController = new SetterInjectedController();
    setterInjectedController.setGreetingService(new GreetingServiceImpl());
  }

  @Test
  void sayHello() {
    String response = setterInjectedController.sayHello();
    assertEquals(GREETING, response);
  }

  @Test
  void testSetterInjectedController_noSettingService_ThrowsNullPointerException() {
    SetterInjectedController controller = new SetterInjectedController();
    assertThrows(NullPointerException.class, controller::sayHello);
  }
}
