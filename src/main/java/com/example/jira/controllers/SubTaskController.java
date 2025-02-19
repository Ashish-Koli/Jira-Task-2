package com.example.jira.controllers;

import com.example.jira.dto.SubTaskDTOs.SubTaskDTO;
import com.example.jira.dto.SubTaskDTOs.SubTaskResponseDTO;
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

    @PostMapping("")
    public ResponseEntity<SubTask> createSubTask(@RequestBody SubTaskDTO subTaskDTO){
        return new ResponseEntity<>(subTaskService.createSubtask(subTaskDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allSubTasks")
    public ResponseEntity<List<SubTask>> getAllSubTasks(){
        return new ResponseEntity<>(subTaskService.getAllSubTasks(), HttpStatus.OK);
    }

    @GetMapping("/{subTaskId}")
    public ResponseEntity<SubTask> getSubTask(@PathVariable int subTaskId){
        return new ResponseEntity<>(subTaskService.getSubTask(subTaskId), HttpStatus.OK);
    }

    @GetMapping("/allSubTasks/{storyId}")
    public ResponseEntity<List<SubTaskResponseDTO>> getAllSubTaskByStoryId(@PathVariable int storyId) {
        return new ResponseEntity<>(subTaskService.getAllSubTaskByStoryId(storyId), HttpStatus.OK);
    }

    @PutMapping("/{subTaskId}")
    public ResponseEntity<SubTask> updateSubTask(@RequestBody SubTaskDTO subTaskDTO, @PathVariable int subTaskId){
        return new ResponseEntity<>(subTaskService.updateSubTask(subTaskDTO, subTaskId), HttpStatus.OK);
    }

    @DeleteMapping("/{subTaskId}")
    public ResponseEntity<String> deleteSubTask(@PathVariable int subTaskId){
        subTaskService.deleteSubTask(subTaskId);
        return new ResponseEntity<>("SubTask Deleted.", HttpStatus.OK);
    }

}
