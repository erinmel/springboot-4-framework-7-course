package com.emelgoza.sfudemy.service.environmentService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnvironmentImpl implements EnvironmentService {
  @Override
  public String getEnvironment() {
    return "qa";
  }
}
