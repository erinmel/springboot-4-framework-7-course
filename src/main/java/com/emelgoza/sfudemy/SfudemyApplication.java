package com.emelgoza.sfudemy;

import com.emelgoza.sfudemy.controller.greeting.GreetingController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SfudemyApplication {

  static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SfudemyApplication.class, args);

    GreetingController controller = ctx.getBean(GreetingController.class);
    log.info(controller.sayHello());
  }
}
