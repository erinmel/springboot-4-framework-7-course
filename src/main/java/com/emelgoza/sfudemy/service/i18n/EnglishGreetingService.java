package com.emelgoza.sfudemy.service.i18n;

import com.emelgoza.sfudemy.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18NService")
public class EnglishGreetingService implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hello World!";
  }
}
