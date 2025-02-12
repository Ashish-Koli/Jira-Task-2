package com.example.jira.services;

import com.example.jira.dto.EpicDTO;
import com.example.jira.dto.ProjectDTOs.ProjectNamesResponseDTO;
import com.example.jira.dto.EpicDTOs.EpicResponseDTO;
import com.example.jira.models.Epic;
import com.example.jira.models.Project;
import com.example.jira.repositories.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicService {

    @Autowired
    private EpicRepository epicRepository;

    @Autowired
    private ProjectService projectService;


    public Epic createEpic(EpicDTO epicDTO){
        Epic epic = new Epic();
        epic.setEpicName(epicDTO.getEpicName());
        epic.setDescription(epicDTO.getDescription());
        Project project = projectService.getProject(epicDTO.getProject());
        epic.setProject(project);
        return epicRepository.save(epic);
    }

    public List<EpicResponseDTO> getAllEpics(){
        return epicRepository.findAll().stream().map(epic -> {
            EpicResponseDTO epicResponseDTO = new EpicResponseDTO();
            epicResponseDTO.setEpicId(epic.getEpicId());
            epicResponseDTO.setEpicName(epic.getEpicName());
            epicResponseDTO.setDescription(epic.getDescription());
            Project project = projectService.getProject(epic.getProject().getProjectId());
            ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
            projectNamesResponseDTO.setProjectId(project.getProjectId());
            projectNamesResponseDTO.setProjectName(project.getProjectName());
            epicResponseDTO.setProject(projectNamesResponseDTO);
            return epicResponseDTO;
        }).toList();
    }

    public List<EpicResponseDTO> getAllEpicsByUserId(int id){
        return epicRepository.findEpicsByUserId(id).stream().map(epic -> {
            EpicResponseDTO epicResponseDTO = new EpicResponseDTO();
            epicResponseDTO.setEpicId(epic.getEpicId());
            epicResponseDTO.setEpicName(epic.getEpicName());
            epicResponseDTO.setDescription(epic.getDescription());
            Project project = projectService.getProject(epic.getProject().getProjectId());
            ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
            projectNamesResponseDTO.setProjectId(project.getProjectId());
            projectNamesResponseDTO.setProjectName(project.getProjectName());
            epicResponseDTO.setProject(projectNamesResponseDTO);
            return epicResponseDTO;
        }).toList();
    }

    public Epic getEpic(int id){
        return epicRepository.findById(id).orElseThrow();
    }

    //change
    public Epic updateEpic(EpicDTO epicDTO, int id){
        Epic updateEpic = epicRepository.findById(id).orElseThrow();
        updateEpic.setEpicName(epicDTO.getEpicName());
        updateEpic.setDescription(epicDTO.getDescription());
        Project project = projectService.getProject(epicDTO.getProject());
        updateEpic.setProject(project);
        return epicRepository.save(updateEpic);
    }

    public void deleteEpic(int id){
        epicRepository.deleteById(id);
    }
}
