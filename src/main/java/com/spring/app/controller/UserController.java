package com.spring.app.controller;

import com.spring.app.domain.UserEntity;
import com.spring.app.dto.AuthenticationDTO;
import com.spring.app.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
      this.userService = userService;
    }

  @GetMapping("/{username}")
  public UserEntity getOneUser(@PathVariable String username){
      return userService.findOneUser(username);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("")
    public void addRoleToUser(@RequestParam String username, @RequestParam String roleName){
        userService.addRoleToUser(username, roleName);
    }



}
