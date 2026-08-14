package com.emelgoza.sfudemy.controller.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
class Myi18NControllerTest {

  @Nested
  @TestPropertySource(properties = "i18n.language=EN")
  class WhenEnglish {
    @Autowired Myi18NController myi18NController;

    @Test
    void sayHelloEn() {
      assertEquals("Hello World!", myi18NController.sayHello());
    }
  }

  @Nested
  @TestPropertySource(properties = "i18n.language=ES")
  class WhenSpanish {
    @Autowired Myi18NController myi18NController;

    @Test
    void sayHelloEs() {
      assertEquals("Hola Mundo!", myi18NController.sayHello());
    }
  }
}
