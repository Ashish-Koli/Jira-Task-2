package com.example.jira.services;

import com.example.jira.models.Epic;
import com.example.jira.repositories.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicService {

    @Autowired
    private EpicRepository epicRepository;

    public Epic createEpic(Epic epic){
        return epicRepository.save(epic);
    }

    public List<Epic> getAllEpics(){
        return epicRepository.findAll();
    }

    public Epic getEpic(int id){
        return epicRepository.findById(id).orElseThrow();
    }

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
