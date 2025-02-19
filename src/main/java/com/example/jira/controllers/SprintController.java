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

    @PostMapping("")
    public ResponseEntity<Sprint> createSprint(@RequestBody SprintDTO sprintDTO){
        return new ResponseEntity<>(sprintService.createSprint(sprintDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allSprints")
    public ResponseEntity<List<Sprint>> getAllSprints(){
        return new ResponseEntity<>(sprintService.getALlSprint(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Sprint> getSprint(@PathVariable int id){
//        return new ResponseEntity<>(sprintService.getSprint(id), HttpStatus.OK);
//    }

    @GetMapping("/{sprintId}")
    public ResponseEntity<SprintResponseDTO> getSprintDetails(@PathVariable int sprintId){
        return new ResponseEntity<>(sprintService.getSprintDetails(sprintId), HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SprintResponseDTO>> getSprintByUserId(@PathVariable int userId){
        return new ResponseEntity<>(sprintService.getSprintByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/stories/{sprintId}")
    public ResponseEntity<Map<String, List<StoryResponseDTO>>> getCategorizedStories(@PathVariable int sprintId) {
            return ResponseEntity.ok(sprintService.getCategorizedStoriesBySprintId(sprintId));
    }

    @PutMapping("/{sprintId}")
    public ResponseEntity<Sprint> updateSprint(@RequestBody SprintDTO sprintDTO, @PathVariable  int sprintId){
        return new ResponseEntity<>(sprintService.updateSprint(sprintDTO, sprintId), HttpStatus.OK);
    }

    @DeleteMapping("/{sprintId}")
    public ResponseEntity<Object> deleteSprint(@PathVariable int sprintId){
        sprintService.deleteSprint(sprintId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
