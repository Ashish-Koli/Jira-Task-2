package com.example.jira.services;

import com.example.jira.dto.LoginDTO;
import com.example.jira.dto.UserDTO;
import com.example.jira.dto.responseDTO.TokenResponse;
import com.example.jira.dto.responseDTO.UserResponseDTO;
import com.example.jira.exception.UserNotFoundException;
import com.example.jira.models.Role;
import com.example.jira.models.User;
import com.example.jira.repositories.RoleRepository;
import com.example.jira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    public User createUser(UserDTO user){
        Role role = roleRepository.findById(user.getRole()).orElseThrow();
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    public List<UserResponseDTO> getAllUsers(){

        return userRepository.findAll().stream().map((user)->{
            UserResponseDTO userResponseDTO  = new UserResponseDTO();
            userResponseDTO.setUserId(user.getUserId());
            userResponseDTO.setUserName(user.getUserName());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setRole(user.getRole().getTitle());
            return userResponseDTO;
        }).toList();
    }

    public User getUser(int id){
        return userRepository.findById(id).orElseThrow();
    }


    public User updateUser(UserDTO user, int id){
        User updateUser = userRepository.findById(id).orElseThrow();
        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findById(user.getRole()).orElseThrow();

        updateUser.setRole(role);

        return userRepository.save(updateUser);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public String verify(LoginDTO loginDTO){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(loginDTO.getUserName());
        }


          return "fail";
    }
}
