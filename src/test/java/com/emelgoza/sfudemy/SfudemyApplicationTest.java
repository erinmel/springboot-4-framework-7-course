package com.emelgoza.sfudemy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.emelgoza.sfudemy.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SfudemyApplicationTest {

  @Autowired ApplicationContext applicationContext;

  @Autowired MyController myController;

  @Test
  void contextLoads() {}

  @Test
  void getControllerFromContext() {
    MyController controller = applicationContext.getBean(MyController.class);

    assertNotNull(controller);

    String response = controller.sayHello();

    assertNotNull(response);
    assertEquals("Hello from MyController", response);
  }

  @Test
  void testAutowiredOfController() {
    assertNotNull(myController);

    String response = myController.sayHello();

    assertNotNull(response);
    assertEquals("Hello from MyController", response);
  }
}
