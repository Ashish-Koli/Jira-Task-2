package com.example.jira.services;

import com.example.jira.models.StoryStatus;
import com.example.jira.repositories.StoryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryStatusService {

    @Autowired
    private StoryStatusRepository storyStatusRepository;

    public StoryStatus createStoryStatus(StoryStatus storyStatus){
        return storyStatusRepository.save(storyStatus);
    }

    public List<StoryStatus> getAllStoryStatus(){
        return storyStatusRepository.findAll();
    }

    public StoryStatus getStoryStatus(int id){
        return storyStatusRepository.findById(id).orElseThrow();
    }

    public StoryStatus updateStoryStatus(StoryStatus storyStatus, int id){
        StoryStatus updateStoryStatus = storyStatusRepository.findById(id).orElseThrow();
        updateStoryStatus.setName(storyStatus.getName());
        return storyStatusRepository.save(updateStoryStatus);
    }

    public void deleteStoryStatus(int id){
        storyStatusRepository.deleteById(id);
    }

}
