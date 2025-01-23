package com.example.jira.services;

import com.example.jira.models.Sprint;
import com.example.jira.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public Sprint createSprint(Sprint sprint){
        return sprintRepository.save(sprint);
    }

    public List<Sprint> getALlSprint(){
        return sprintRepository.findAll();
    }

    public Sprint getSprint(int id){
        return sprintRepository.findById(id).orElseThrow();
    }

    public Sprint updateSprint(Sprint sprint, int id){
        Sprint updateSprint =  sprintRepository.findById(id).orElseThrow();
        updateSprint.setSprintNo(sprint.getSprintNo());
        updateSprint.setSprintName(sprint.getSprintName());
        updateSprint.setSprintPoint(sprint.getSprintPoint());
        updateSprint.setStartDate(sprint.getStartDate());
        updateSprint.setEndDate(sprint.getEndDate());
        return sprintRepository.save(updateSprint);
    }

    public void deleteSprint(int id){
        sprintRepository.deleteById(id);
    }


}
