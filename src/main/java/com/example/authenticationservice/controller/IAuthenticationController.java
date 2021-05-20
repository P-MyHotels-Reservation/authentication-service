package com.example.authenticationservice.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public interface IAuthenticationController {

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "created user",
          content = {@Content(mediaType = "application/json")})})
  String hello();
}
