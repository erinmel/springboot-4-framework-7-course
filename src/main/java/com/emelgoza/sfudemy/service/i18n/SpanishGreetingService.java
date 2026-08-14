package com.emelgoza.sfudemy.service.i18n;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("i18NService")
@ConditionalOnProperty(prefix = "i18n", name = "language", havingValue = "ES")
public class SpanishGreetingService implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hola Mundo!";
  }
}
