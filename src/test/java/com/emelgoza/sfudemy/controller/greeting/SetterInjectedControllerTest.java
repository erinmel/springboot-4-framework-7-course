package com.emelgoza.sfudemy.controller.greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("EN")
@SpringBootTest
class SetterInjectedControllerTest {
  private static final String GREETING = "Hola a todos!";

  @Autowired private SetterInjectedController setterInjectedController;

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
