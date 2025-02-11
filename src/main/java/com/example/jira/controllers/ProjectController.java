package com.example.jira.controllers;

import com.example.jira.dto.ProjectDTO;
import com.example.jira.dto.ProjectDTOs.ProjectResponseDTO;
import com.example.jira.dto.responseDTO.ProjectNamesResponseDTO;
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
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectDTO projectDTO){
        return  new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allProject")
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id){
        return new ResponseEntity<>(projectService.getProject(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<ProjectResponseDTO> getProjectsByUserId(@PathVariable int userId) {
        return projectService.getProjectsByUserId(userId);
    }

    @GetMapping("/projectNames/user/{userId}")
    public List<ProjectNamesResponseDTO> getProjectsNamesByUserId(@PathVariable int userId) {
        return projectService.getProjectsNamesByUserId(userId);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable  int id){
        return new ResponseEntity<>(projectService.updateProject(projectDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable int id){
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
