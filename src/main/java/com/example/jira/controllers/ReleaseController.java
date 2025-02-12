package com.example.jira.controllers;

import com.example.jira.dto.ReleaseDTO;
import com.example.jira.models.Release;
import com.example.jira.services.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping("/create")
    public ResponseEntity<Release> createRelease(@RequestBody ReleaseDTO releaseDTO){
        return new ResponseEntity<>(releaseService.createRelease(releaseDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/allRelease")
//    public ResponseEntity<List<Release>> getAllRelease(){
//        return new ResponseEntity<>(releaseService.getAllRelease(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Release> getRelease(@PathVariable int id){
//        return new ResponseEntity<>(releaseService.getRelease(id), HttpStatus.FOUND);
//    }

//    @GetMapping("/release/{id}")
//    public ResponseEntity<Release> getReleaseBySprintId(@PathVariable int id){
//        return new ResponseEntity<>(releaseService.getReleaseBySprintId(id), HttpStatus.FOUND);
//    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<Release> updateRelease(@RequestBody ReleaseDTO releaseDTO,@PathVariable int id){
//        return new ResponseEntity<>(releaseService.updateRelease(releaseDTO, id), HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<Release> updateReleaseBySprintId(@RequestBody ReleaseDTO releaseDTO){
        return new ResponseEntity<>(releaseService.updateReleaseBySprintId(releaseDTO), HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteRelease(@PathVariable int id){
//        releaseService.deleteRelease(id);
//        return new ResponseEntity<>("Release Deleted.", HttpStatus.OK);
//    }

}
