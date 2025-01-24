package com.example.jira.controllers;

import com.example.jira.dto.SubTaskDTO;
import com.example.jira.models.SubTask;
import com.example.jira.services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subTask")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping("/create")
    public ResponseEntity<SubTask> createSubTask(SubTaskDTO subTaskDTO){
        return new ResponseEntity<>(subTaskService.createSubtask(subTaskDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allSubTask")
    public ResponseEntity<List<SubTask>> getAllSubTasks(){
        return new ResponseEntity<>(subTaskService.getAllSubTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTask> getSubTask(@PathVariable int id){
        return new ResponseEntity<>(subTaskService.getSubTask(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubTask> updateSubTask(@RequestBody SubTaskDTO subTaskDTO, @PathVariable int id){
        return new ResponseEntity<>(subTaskService.updateSubTask(subTaskDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubTask(@PathVariable int id){
        subTaskService.deleteSubTask(id);
        return new ResponseEntity<>("SubTask Deleted.", HttpStatus.OK);
    }

}
