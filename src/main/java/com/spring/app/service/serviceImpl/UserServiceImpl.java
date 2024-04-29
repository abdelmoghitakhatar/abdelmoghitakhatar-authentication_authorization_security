package com.spring.app.service.serviceImpl;

import com.spring.app.domain.RoleEntity;
import com.spring.app.domain.UserEntity;
import com.spring.app.repository.UserRepository;
import com.spring.app.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    UserServiceImpl(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity findOneUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity user = userRepository.findUserByUsername(username);
        RoleEntity role = roleService.getRole(roleName);

        user.getRoles().add(role);
    }

}
