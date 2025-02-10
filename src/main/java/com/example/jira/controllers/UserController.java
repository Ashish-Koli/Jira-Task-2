package com.example.jira.controllers;


import com.example.jira.dto.LoginDTO;
import com.example.jira.dto.responseDTO.TokenResponse;
import com.example.jira.dto.UserDTO;
import com.example.jira.dto.responseDTO.UserResponseDTO;
import com.example.jira.models.User;
import com.example.jira.repositories.UserRepository;
import com.example.jira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO user, @PathVariable int id){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted.",HttpStatus.NO_CONTENT);
    }


    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginDTO loginDTO){
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(userService.verify(loginDTO));
        User user = userRepository.findByUserName(loginDTO.getUserName()).orElseThrow();
        tokenResponse.setUserId(user.getUserId());
        tokenResponse.setRole(user.getRole().getTitle());
        return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
    }

}
