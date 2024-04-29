package com.spring.app.service;

import com.spring.app.domain.RoleEntity;
import com.spring.app.domain.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity addUser(UserEntity user);

    UserEntity findOneUser(String username);

    List<UserEntity> findAllUsers();

    void addRoleToUser(String username, String roleName);

}
