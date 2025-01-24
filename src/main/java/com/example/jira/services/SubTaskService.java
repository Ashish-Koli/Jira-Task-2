package com.example.jira.services;

import com.example.jira.dto.SubTaskDTO;
import com.example.jira.models.Story;
import com.example.jira.models.SubTask;
import com.example.jira.repositories.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepository subTaskRepository;
    @Autowired
    private StoryService storyService;

    public SubTask createSubtask(SubTaskDTO subTaskDTO){
        Story story = storyService.getStory(subTaskDTO.getStory());
        SubTask subTask = new SubTask();
        subTask.setTaskName(subTaskDTO.getTaskName());
        subTask.setDescription(subTask.getDescription());
        subTask.setStory(story);
        return subTaskRepository.save(subTask);
    }

}
