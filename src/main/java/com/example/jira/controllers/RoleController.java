package com.example.jira.controllers;

import com.example.jira.dto.responseDTO.RoleResponseDTO;
import com.example.jira.models.Role;
import com.example.jira.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK) ;
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable int roleId){
        return new ResponseEntity<>(roleService.update(role,roleId),HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable int roleId){
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
