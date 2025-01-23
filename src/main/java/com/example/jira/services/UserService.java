package com.example.jira.services;

import com.example.jira.dto.UserDTO;
import com.example.jira.models.Role;
import com.example.jira.models.User;
import com.example.jira.repositories.RoleRepository;
import com.example.jira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createUser(UserDTO user){
        Role role = roleRepository.findById(user.getRole()).orElseThrow();
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(UserDTO user, int id){
        User updateUser = userRepository.findById(id).orElseThrow();
        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());

        Role role = roleRepository.findById(user.getRole()).orElseThrow();

        updateUser.setRole(role);

        return userRepository.save(updateUser);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
