package com.example.jira.controllers;

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

    @PostMapping("/create")
    public ResponseEntity<Epic> createEpic(@RequestBody Epic epic){
        return new ResponseEntity<>(epicService.createEpic(epic), HttpStatus.CREATED);
    }

    @GetMapping("/allEpic")
    public ResponseEntity<List<Epic>> getAllEpics(){
        return new ResponseEntity<>(epicService.getAllEpics(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epic> getEpic(@PathVariable int id){
        return new ResponseEntity<>(epicService.getEpic(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Epic> updateEpic(@RequestBody Epic epic, @PathVariable int id){
        return new ResponseEntity<>(epicService.updateEpic(epic, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEpic(@PathVariable int id){
        epicService.deleteEpic(id);
        return new ResponseEntity<>("Epic Deleted.", HttpStatus.OK);
    }
}
