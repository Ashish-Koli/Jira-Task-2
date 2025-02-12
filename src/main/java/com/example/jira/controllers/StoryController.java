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

    @PostMapping("/create")
    public ResponseEntity<Story> createStory(@RequestBody StoryDTO storyDTO){
        return new ResponseEntity<>(storyService.createStory(storyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allStory")
    public ResponseEntity<List<StoryResponseDTO>> getAllStory(){
        return new ResponseEntity<>(storyService.getALlStory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryResponseDTO> getStory(@PathVariable int id){
        return new ResponseEntity<>(storyService.getStory(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Story> updateStory(@RequestBody StoryDTO storyDTO,@PathVariable int id){
        return new ResponseEntity<>(storyService.updateStory(storyDTO, id), HttpStatus.OK);
    }

    @PutMapping("update/storyStatus/{id}")
    public ResponseEntity<Story> updateStoryStatus(@RequestBody UpdateStoryStatusDTO statusDTO, @PathVariable int id){
        return new ResponseEntity<>(storyService.updateStoryStatus(statusDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStory(@PathVariable int id){
        storyService.deleteStory(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
