package com.example.authenticationservice.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements IAuthenticationController{

  @Override
  public String hello() {
    return "Hello World";
  }
}
