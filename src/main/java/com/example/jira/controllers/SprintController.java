package com.example.jira.controllers;

import com.example.jira.dto.SprintDTOs.SprintDTO;
import com.example.jira.dto.SprintDTOs.SprintResponseDTO;
import com.example.jira.dto.StoryDTOs.StoryResponseDTO;
import com.example.jira.models.Sprint;
import com.example.jira.models.Story;
import com.example.jira.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/details/{id}")
    public ResponseEntity<SprintResponseDTO> getSprintDetails(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprintDetails(id), HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<SprintResponseDTO>> getSprintByUserId(@PathVariable int id){
        return new ResponseEntity<>(sprintService.getSprintByUserId(id),HttpStatus.OK);
    }

    @GetMapping("/{sprintId}/stories")
    public ResponseEntity<Map<String, List<StoryResponseDTO>>> getCategorizedStories(@PathVariable int sprintId) {
            return ResponseEntity.ok(sprintService.getCategorizedStoriesBySprintId(sprintId));
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
