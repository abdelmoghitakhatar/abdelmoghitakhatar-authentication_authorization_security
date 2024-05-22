package com.spring.app.dto;

import com.spring.app.domain.RoleEntity;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private Long id;

  private String username;

  private String password;

  private Set<RoleEntity> roles = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<RoleEntity> getRoles() {
    return roles;
  }

  public void setRoles(Set<RoleEntity> roles) {
    this.roles = roles;
  }
}
