package com.example.jira.controllers;

import com.example.jira.dto.SubTaskDTO;
import com.example.jira.models.SubTask;
import com.example.jira.services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subTask")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping("/create")
    public ResponseEntity<SubTask> createSubTask(SubTaskDTO subTaskDTO){
        return new ResponseEntity<>(subTaskService.createSubtask(subTaskDTO), HttpStatus.CREATED);
    }
}
