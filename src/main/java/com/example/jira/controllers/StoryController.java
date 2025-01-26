package com.example.jira.controllers;

import com.example.jira.dto.StoryDTO;
import com.example.jira.models.Story;
import com.example.jira.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @PostMapping("/create")
    public ResponseEntity<Story> createStory(@RequestBody StoryDTO storyDTO){
        return new ResponseEntity<>(storyService.createStory(storyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allStory")
    public ResponseEntity<List<Story>> getAllStory(){
        return new ResponseEntity<>(storyService.getALlStory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Story> getStory(@PathVariable int id){
        return new ResponseEntity<>(storyService.getStory(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Story> updateStory(@RequestBody StoryDTO storyDTO,@PathVariable int id){
        return new ResponseEntity<>(storyService.updateStory(storyDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStory(@PathVariable int id){
        storyService.deleteStory(id);
        return new ResponseEntity<>("Story Deleted.", HttpStatus.OK);
    }


}
