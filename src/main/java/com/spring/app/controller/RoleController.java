package com.spring.app.controller;

import com.spring.app.domain.RoleEntity;
import com.spring.app.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RoleController {

    private RoleService roleService;
    
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role")
    public void addRole(@RequestBody RoleEntity role){
        roleService.addRole(role);
    }

    @GetMapping("/role/{roleName}")
    public RoleEntity getOneRole(@PathVariable String roleName){
        return roleService.getRole(roleName);
    }
}
