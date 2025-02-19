package com.example.jira.controllers;

import com.example.jira.dto.ProjectDTOs.ProjectDTO;
import com.example.jira.dto.ProjectDTOs.ProjectResponseDTO;
import com.example.jira.dto.ProjectDTOs.ProjectNamesResponseDTO;
import com.example.jira.models.Project;
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

    @PostMapping("")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectDTO projectDTO){
        return  new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allProjects")
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable int projectId){
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<ProjectResponseDTO> getProjectsByUserId(@PathVariable int userId) {
        return projectService.getProjectsByUserId(userId);
    }

    @GetMapping("/projectNames/user/{userId}")
    public List<ProjectNamesResponseDTO> getProjectsNamesByUserId(@PathVariable int userId) {
        return projectService.getProjectsNamesByUserId(userId);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable  int projectId){
        return new ResponseEntity<>(projectService.updateProject(projectDTO, projectId), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Object> deleteProject(@PathVariable int projectId){
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
