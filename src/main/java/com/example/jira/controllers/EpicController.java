package com.example.jira.controllers;

import com.example.jira.dto.EpicDTO;
import com.example.jira.dto.responseDTO.EpicResponseDTO;
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
    public ResponseEntity<Epic> createEpic(@RequestBody EpicDTO epicDTO){
        return new ResponseEntity<>(epicService.createEpic(epicDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allEpic")
    public ResponseEntity<List<EpicResponseDTO>> getAllEpics(){
        return new ResponseEntity<>(epicService.getAllEpics(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epic> getEpic(@PathVariable int id){
        return new ResponseEntity<>(epicService.getEpic(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Epic> updateEpic(@RequestBody EpicDTO epicDTO, @PathVariable int id){
        return new ResponseEntity<>(epicService.updateEpic(epicDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEpic(@PathVariable int id){
        epicService.deleteEpic(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
