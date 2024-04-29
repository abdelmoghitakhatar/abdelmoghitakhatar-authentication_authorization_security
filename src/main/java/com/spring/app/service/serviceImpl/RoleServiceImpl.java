package com.spring.app.service.serviceImpl;

import com.spring.app.domain.RoleEntity;
import com.spring.app.repository.RoleRepository;
import com.spring.app.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity addRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity getRole(String roleName) {
        RoleEntity role = roleRepository.findRoleByRoleName(roleName);
        return role;
    }
}
