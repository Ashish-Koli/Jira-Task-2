package com.example.jira.services;

import com.example.jira.exception.UserNotFoundException;
import com.example.jira.models.User;
import com.example.jira.models.UserPrincipal;
import com.example.jira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 = userRepo.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User Not found"));

//        if (user1 == null){
//            System.out.println("hey");
//            try {
//                throw new UserNotFoundException("User not found");
//            } catch (UserNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return new UserPrincipal(user1);
    }
}