package com.emelgoza.sfudemy.service.greeting;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("spanishGreetingService")
@Primary
public class GreetingServiceSpanishImpl implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hola a todos!";
  }
}
