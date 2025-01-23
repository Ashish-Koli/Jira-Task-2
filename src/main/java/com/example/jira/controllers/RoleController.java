package com.example.jira.controllers;

import com.example.jira.models.Role;
import com.example.jira.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @GetMapping("/allRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }



}
