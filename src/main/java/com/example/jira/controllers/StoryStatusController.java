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
public class
StoryStatusController {

    @Autowired
    private StoryStatusService storyStatusService;

    @PostMapping("")
    public ResponseEntity<StoryStatus> createStoryStatus(@RequestBody StoryStatus storyStatus){
        return new ResponseEntity<>(storyStatusService.createStoryStatus(storyStatus), HttpStatus.CREATED);
    }

    @GetMapping("/allStoryStatuses")
    public ResponseEntity<List<StoryStatus>> getAllStoryStatus(){
        return new ResponseEntity<>(storyStatusService.getAllStoryStatus(), HttpStatus.OK);
    }
    
    @GetMapping("/{storyStatusId}")
    public ResponseEntity<StoryStatus> getStoryStatus(@PathVariable int storyStatusId){
        return new ResponseEntity<>(storyStatusService.getStoryStatus(storyStatusId), HttpStatus.OK);
    }

    @PutMapping("/{storyStatusId}")
    public ResponseEntity<StoryStatus> updateStoryStatus(@RequestBody StoryStatus storyStatus, @PathVariable int storyStatusId){
        return new ResponseEntity<>(storyStatusService.updateStoryStatus(storyStatus, storyStatusId), HttpStatus.OK);
    }

    @DeleteMapping("/{storyStatusId}")
    public ResponseEntity<String> deleteStoryStatus(@PathVariable int storyStatusId){
        storyStatusService.deleteStoryStatus(storyStatusId);
        return new ResponseEntity<>("StoryStatus Deleted.", HttpStatus.OK);
    }
}

