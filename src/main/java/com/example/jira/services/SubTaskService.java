package com.example.jira.services;

import com.example.jira.dto.StoryDTOs.StoryNameResponseDTO;
import com.example.jira.dto.SubTaskDTOs.SubTaskDTO;
import com.example.jira.dto.SubTaskDTOs.SubTaskResponseDTO;
import com.example.jira.models.Story;
import com.example.jira.models.SubTask;
import com.example.jira.repositories.StoryRepository;
import com.example.jira.repositories.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepository subTaskRepository;
    @Autowired
    private StoryRepository storyRepository;

    public SubTask createSubtask(SubTaskDTO subTaskDTO){
        Story story = storyRepository.findById(subTaskDTO.getStory()).orElseThrow();
        SubTask subTask = new SubTask();
        subTask.setTaskName(subTaskDTO.getTaskName());
        subTask.setDescription(subTaskDTO.getDescription());
        subTask.setStory(story);
        return subTaskRepository.save(subTask);
    }

    public List<SubTask> getAllSubTasks(){
        return subTaskRepository.findAll();
    }

    public List<SubTaskResponseDTO> getAllSubTaskByStoryId(int id){
        return subTaskRepository.findByStory_StoryId(id).stream().map(subTask -> {
            SubTaskResponseDTO subTaskResponseDTO = new SubTaskResponseDTO();
            subTaskResponseDTO.setTaskId(subTask.getTaskId());
            subTaskResponseDTO.setTaskName(subTask.getTaskName());
            subTaskResponseDTO.setDescription(subTask.getDescription());
            StoryNameResponseDTO story = new StoryNameResponseDTO();
            story.setStoryId(subTask.getStory().getStoryId());
            story.setStoryName(subTask.getStory().getStoryName());
            subTaskResponseDTO.setStory(story);
            return subTaskResponseDTO;
        }).toList();
    }
    public SubTask getSubTask(int id){
        return subTaskRepository.findById(id).orElseThrow();
    }

    public SubTask updateSubTask(SubTaskDTO subTaskDTO, int id){
        SubTask updateSubTask = subTaskRepository.findById(id).orElseThrow();
        Story updatestory = storyRepository.findById(subTaskDTO.getStory()).orElseThrow();
        updateSubTask.setTaskName(subTaskDTO.getTaskName());
        updateSubTask.setDescription(subTaskDTO.getDescription());
        updateSubTask.setStory(updatestory);
        return subTaskRepository.save(updateSubTask);
    }

    public void deleteSubTask(int id){
        subTaskRepository.deleteById(id);
    }


}
