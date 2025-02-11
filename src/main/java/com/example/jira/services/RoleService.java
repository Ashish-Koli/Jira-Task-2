package com.example.jira.services;

import com.example.jira.dto.responseDTO.RoleResponseDTO;
import com.example.jira.models.Role;
import com.example.jira.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleResponseDTO createRole(Role role){
        roleRepository.save(role);
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setId(role.getId());
        roleResponseDTO.setTitle(role.getTitle());
        return  roleResponseDTO;
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }


    public Role update(Role role, int id) {
        Role updateRole = roleRepository.findById(id).orElseThrow();
        updateRole.setTitle(role.getTitle());
        return roleRepository.save(updateRole);
    }

    public void  deleteRole(int id) {
         roleRepository.deleteById(id);
    }
}
