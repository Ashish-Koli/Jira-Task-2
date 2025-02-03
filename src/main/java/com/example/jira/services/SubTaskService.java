package com.example.jira.services;

import com.example.jira.dto.SubTaskDTO;
import com.example.jira.models.Story;
import com.example.jira.models.SubTask;
import com.example.jira.repositories.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        subTask.setDescription(subTaskDTO.getDescription());
        subTask.setStory(story);
        return subTaskRepository.save(subTask);
    }

    public List<SubTask> getAllSubTasks(){
        return subTaskRepository.findAll();
    }

    public List<SubTask> getAllSubTaskByStoryId(int id){
        return subTaskRepository.findByStory_StoryId(id);
    }
    public SubTask getSubTask(int id){
        return subTaskRepository.findById(id).orElseThrow();
    }

    public SubTask updateSubTask(SubTaskDTO subTaskDTO, int id){
        SubTask updateSubTask = subTaskRepository.findById(id).orElseThrow();
        Story updatestory = storyService.getStory(subTaskDTO.getStory());
        updateSubTask.setTaskName(subTaskDTO.getTaskName());
        updateSubTask.setDescription(subTaskDTO.getDescription());
        updateSubTask.setStory(updatestory);
        return subTaskRepository.save(updateSubTask);
    }

    public void deleteSubTask(int id){
        subTaskRepository.deleteById(id);
    }


}
