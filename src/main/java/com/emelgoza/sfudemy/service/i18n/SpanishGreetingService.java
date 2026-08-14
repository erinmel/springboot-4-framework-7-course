package com.emelgoza.sfudemy.service.i18n;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18NService")
public class SpanishGreetingService implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hola Mundo!";
  }
}
