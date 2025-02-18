package com.example.jira.controllers;

import com.example.jira.dto.MailRequestDTO;
import com.example.jira.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public ResponseEntity<Void> emailNotification(@RequestBody MailRequestDTO mailRequestDTO){
        emailService.sendEmail(mailRequestDTO.getTo(), mailRequestDTO.getSubject(), mailRequestDTO.getBody());
        return  new ResponseEntity<>( HttpStatus.OK);
    }
}
