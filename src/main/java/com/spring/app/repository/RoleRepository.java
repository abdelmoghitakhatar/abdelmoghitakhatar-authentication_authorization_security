package com.spring.app.repository;

import com.spring.app.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleByRoleName(String roleName);
}
