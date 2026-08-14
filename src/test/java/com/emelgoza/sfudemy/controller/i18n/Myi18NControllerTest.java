package com.emelgoza.sfudemy.controller.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

abstract class Myi18NControllerTest {

  @Autowired Myi18NController myi18NController;

  protected abstract String expectedGreeting();

  @Test
  void sayHello() {
    String response = myi18NController.sayHello();
    assertEquals(expectedGreeting(), response);
  }
}

@ActiveProfiles("ES")
@SpringBootTest
class Myi18NControllerESTest extends Myi18NControllerTest {
  @Override
  protected String expectedGreeting() {
    return "Hola Mundo!";
  }
}

@ActiveProfiles("EN")
@SpringBootTest
class Myi18NControllerENTest extends Myi18NControllerTest {
  @Override
  protected String expectedGreeting() {
    return "Hello World!";
  }
}
