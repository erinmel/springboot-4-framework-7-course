package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.environmentService.EnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

  private final EnvironmentService environmentService;

  public EnvironmentController(EnvironmentService environmentService) {
    this.environmentService = environmentService;
  }

  public String getEnvironment() {
    return String.format("The current environment is: %s", environmentService.getEnvironment());
  }
}
