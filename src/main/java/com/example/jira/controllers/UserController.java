package com.example.jira.controllers;


import com.example.jira.dto.LoginDTO;
import com.example.jira.dto.UserDTOs.PasswordChangeDTO;
import com.example.jira.dto.UserDTOs.ProfileDTO;
import com.example.jira.dto.responseDTO.TokenResponse;
import com.example.jira.dto.UserDTOs.UserDTO;
import com.example.jira.dto.UserDTOs.UserResponseDTO;
import com.example.jira.models.User;
import com.example.jira.repositories.UserRepository;
import com.example.jira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/sprint/{sprintId}")
    public ResponseEntity<List<UserResponseDTO>> getAllUsersBySprintId(@PathVariable int sprintId){
        return new ResponseEntity<>(userService.getAllUsersBySprintId(sprintId), HttpStatus.OK);
    }

    @PutMapping("/updateProfile/{userId}")
    public ResponseEntity<UserResponseDTO> updateProfile(@RequestBody ProfileDTO profileDTO, @PathVariable int userId){
        return new ResponseEntity<>(userService.updateProfile(profileDTO, userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserDTO user, @PathVariable int userId){
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @PutMapping("/changePassword/{userId}")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeDTO passwordChangeDTO, @PathVariable int userId) throws Exception {
        userService.changePassword(passwordChangeDTO, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
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
