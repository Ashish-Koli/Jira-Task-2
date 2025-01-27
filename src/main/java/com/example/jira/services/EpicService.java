package com.example.jira.services;

import com.example.jira.dto.EpicDTO;
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

    public List<Epic> getAllEpics(){
        return epicRepository.findAll();
    }

    public Epic getEpic(int id){
        return epicRepository.findById(id).orElseThrow();
    }

    //change
    public Epic updateEpic(Epic epic, int id){
        Epic updateEpic = epicRepository.findById(id).orElseThrow();
        updateEpic.setEpicName(epic.getEpicName());
        updateEpic.setDescription(epic.getDescription());
        return epicRepository.save(updateEpic);
    }

    public void deleteEpic(int id){
        epicRepository.deleteById(id);
    }
}
