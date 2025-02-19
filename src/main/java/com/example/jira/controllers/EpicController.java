package com.example.jira.controllers;

import com.example.jira.dto.EpicDTO;
import com.example.jira.dto.EpicDTOs.EpicResponseDTO;
import com.example.jira.models.Epic;
import com.example.jira.services.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epic")
public class EpicController {

    @Autowired
    private EpicService epicService;

    @PostMapping("")
    public ResponseEntity<Epic> createEpic(@RequestBody EpicDTO epicDTO){
        return new ResponseEntity<>(epicService.createEpic(epicDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allEpics")
    public ResponseEntity<List<EpicResponseDTO>> getAllEpics(){
        return new ResponseEntity<>(epicService.getAllEpics(), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EpicResponseDTO>> getAllEpicBYUserId(@PathVariable int userId){
        return new ResponseEntity<>(epicService.getAllEpicsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{epicId}")
    public ResponseEntity<Epic> getEpic(@PathVariable int epicId){
        return new ResponseEntity<>(epicService.getEpic(epicId), HttpStatus.OK);
    }

    @PutMapping("/{epicId}")
    public ResponseEntity<Epic> updateEpic(@RequestBody EpicDTO epicDTO, @PathVariable int epicId){
        return new ResponseEntity<>(epicService.updateEpic(epicDTO, epicId), HttpStatus.OK);
    }

    @DeleteMapping("/{epicId}")
    public ResponseEntity<Object> deleteEpic(@PathVariable int epicId){
        epicService.deleteEpic(epicId);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
