package com.spring.app.controller;

import com.spring.app.domain.UserEntity;
import com.spring.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{username}")
    public UserEntity getOneUser(@PathVariable String username){
        return userService.findOneUser(username);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("/user")
    public void addRoleToUser(@RequestParam String username, @RequestParam String roleName){
        userService.addRoleToUser(username, roleName);
    }



}
