package com.emelgoza.sfudemy.service.environmentService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevEnvironmentImpl implements EnvironmentService {
  @Override
  public String getEnvironment() {
    return "dev";
  }
}
