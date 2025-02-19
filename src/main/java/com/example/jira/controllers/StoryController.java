package com.example.jira.controllers;

import com.example.jira.dto.StoryDTOs.StoryDTO;
import com.example.jira.dto.StoryDTOs.StoryResponseDTO;
import com.example.jira.dto.UpdateStoryStatusDTO;
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

    @PostMapping("")
    public ResponseEntity<StoryResponseDTO> createStory(@RequestBody StoryDTO storyDTO){
        return new ResponseEntity<>(storyService.createStory(storyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allStories")
    public ResponseEntity<List<StoryResponseDTO>> getAllStory(){
        return new ResponseEntity<>(storyService.getALlStory(), HttpStatus.OK);
    }

    @GetMapping("/{storyId}")
    public ResponseEntity<StoryResponseDTO> getStory(@PathVariable int storyId){
        return new ResponseEntity<>(storyService.getStory(storyId), HttpStatus.OK);
    }

    @PutMapping("/{storyId}")
    public ResponseEntity<StoryResponseDTO> updateStory(@RequestBody StoryDTO storyDTO,@PathVariable int storyId){
        return new ResponseEntity<>(storyService.updateStory(storyDTO, storyId), HttpStatus.OK);
    }

    @PutMapping("/storyStatus/{storyId}")
    public ResponseEntity<Story> updateStoryStatus(@RequestBody UpdateStoryStatusDTO statusDTO, @PathVariable int storyId){
        return new ResponseEntity<>(storyService.updateStoryStatus(statusDTO, storyId), HttpStatus.OK);
    }

    @DeleteMapping("/{storyId}")
    public ResponseEntity<Object> deleteStory(@PathVariable int storyId){
        storyService.deleteStory(storyId);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
