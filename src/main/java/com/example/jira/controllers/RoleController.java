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

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable int id){
        return new ResponseEntity<>(roleService.update(role,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable int id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
