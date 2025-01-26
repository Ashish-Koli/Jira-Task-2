package com.example.jira.controllers;

import com.example.jira.dto.ProjectDTO;
import com.example.jira.models.Project;
import com.example.jira.repositories.ProjectRepository;
import com.example.jira.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO){
        return  new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allProject")
    public ResponseEntity<List<Project>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public List<Project> getProjectsByUserId(@PathVariable int userId) {
        return projectService.getProjectsByUserId(userId);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable  int id){
        return new ResponseEntity<>(projectService.updateProject(projectDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id){
        projectService.deleteProject(id);
        return new ResponseEntity<>("Project Deleted.",HttpStatus.OK);
    }
}
