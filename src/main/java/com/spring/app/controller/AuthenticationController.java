package com.spring.app.controller;

import com.spring.app.domain.UserEntity;
import com.spring.app.dto.AuthenticationDTO;
import com.spring.app.service.AuthenticationService;
import com.spring.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthenticationController {

  private UserService userService;
  private AuthenticationService authenticationService;

  public AuthenticationController(UserService userService, AuthenticationService authenticationService) {
    this.userService = userService;
    this.authenticationService = authenticationService;
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody AuthenticationDTO user){
    authenticationService.authenticate(user);
    return new ResponseEntity<>(authenticationService.authenticate(user), HttpStatus.OK);
  }

  @PostMapping("/register")
  public String register(@RequestBody UserEntity user){
    userService.addUser(user);
    return "user created";
  }
}
