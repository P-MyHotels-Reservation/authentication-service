package com.example.authenticationservice.controller;

import com.example.authenticationservice.model.request.AuthenticationRequest;
import com.example.authenticationservice.model.response.AuthenticationResponse;
import com.example.authenticationservice.service.MyUserDetailsService;
import com.example.authenticationservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements IAuthenticationController{

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private MyUserDetailsService userDetailService;
  @Autowired
  private JwtUtil jwtTokenUtil;
  @Override
  public String hello() {
    return "Hello World";
  }

  @Override
  public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      throw new Exception("INCORRECT USERNAME OR PASSWORD", e);
    }

    final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

    final String jwt = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
