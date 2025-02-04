package com.example.jira.controllers;

import com.example.jira.dto.SprintDTO;
import com.example.jira.dto.responseDTO.SprintResponseDTO;
import com.example.jira.models.Sprint;
import com.example.jira.models.Story;
import com.example.jira.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping("/create")
    public ResponseEntity<Sprint> createSprint(@RequestBody SprintDTO sprintDTO){
        return new ResponseEntity<>(sprintService.createSprint(sprintDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allSprint")
    public ResponseEntity<List<Sprint>> getAllSprints(){
        return new ResponseEntity<>(sprintService.getALlSprint(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> getSprint(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprint(id), HttpStatus.OK);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<List<Sprint>> getSprintByBoardId(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprintByBoardId(id),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<SprintResponseDTO>> getSprintByUserId(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprintByUserId(id),HttpStatus.OK);
    }

    @GetMapping("/{sprintId}/stories")
    public ResponseEntity<Map<String, List<Story>>> getCategorizedStories(@PathVariable int sprintId) {
        Map<String, List<Story>> categorizedStories = sprintService.getCategorizedStoriesBySprintId(sprintId);
        return ResponseEntity.ok(categorizedStories);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sprint> updateSprint(@RequestBody SprintDTO sprintDTO, @PathVariable  int id){
        return new ResponseEntity<>(sprintService.updateSprint(sprintDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteSprint(@PathVariable int id){
        sprintService.deleteSprint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
