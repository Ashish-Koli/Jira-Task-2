package com.example.jira.controllers;

import com.example.jira.models.StoryStatus;
import com.example.jira.services.StoryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storyStatus")
public class StoryStatusController {

    @Autowired
    private StoryStatusService storyStatusService;

    @PostMapping("/create")
    public ResponseEntity<StoryStatus> createStoryStatus(@RequestBody StoryStatus storyStatus){
        return new ResponseEntity<>(storyStatusService.createStoryStatus(storyStatus), HttpStatus.CREATED);
    }

    @GetMapping("/allStoryStatus")
    public ResponseEntity<List<StoryStatus>> getAllStoryStatus(){
        return new ResponseEntity<>(storyStatusService.getAllStoryStatus(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StoryStatus> updateStoryStatus(@RequestBody StoryStatus storyStatus, @PathVariable int id){
        return new ResponseEntity<>(storyStatusService.updateStoryStatus(storyStatus, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStoryStatus(@PathVariable int id){
        storyStatusService.deleteStoryStatus(id);
        return new ResponseEntity<>("StoryStatus Deleted.", HttpStatus.OK);
    }
}

