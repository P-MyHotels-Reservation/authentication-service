package com.example.authenticationservice.controller;

import com.example.authenticationservice.model.request.AuthenticationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public interface IAuthenticationController {

  @PostMapping("/home")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "created user",
          content = {@Content(mediaType = "application/json")})})
  String hello();

  @PostMapping("/login")
  ResponseEntity<?> createAuthenticationToken(
      @RequestBody AuthenticationRequest authenticationRequest) throws Exception;
}
