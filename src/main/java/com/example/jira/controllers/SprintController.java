package com.example.jira.controllers;

import com.example.jira.models.Sprint;
import com.example.jira.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping("/create")
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint){
        return new ResponseEntity<>(sprintService.createSprint(sprint), HttpStatus.CREATED);
    }

    @GetMapping("/allSprint")
    public ResponseEntity<List<Sprint>> getAllSprints(){
        return new ResponseEntity<>(sprintService.getALlSprint(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> getSprint(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprint(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sprint> updateSprint(@RequestBody Sprint sprint, @PathVariable  int id){
        return new ResponseEntity<>(sprintService.updateSprint(sprint, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSprint(@PathVariable int id){
        sprintService.deleteSprint(id);
        return new ResponseEntity<>("Sprint Deleted.", HttpStatus.OK);
    }
}
