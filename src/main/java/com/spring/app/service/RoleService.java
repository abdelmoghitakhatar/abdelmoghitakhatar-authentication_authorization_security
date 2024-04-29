package com.spring.app.service;

import com.spring.app.domain.RoleEntity;

public interface RoleService {

    RoleEntity addRole(RoleEntity role);

    RoleEntity getRole(String roleName);
}
