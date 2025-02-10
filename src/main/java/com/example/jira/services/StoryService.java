package com.example.jira.services;

import com.example.jira.dto.StoryDTO;
import com.example.jira.dto.UpdateStoryStatusDTO;
import com.example.jira.models.*;
import com.example.jira.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {


    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private StoryStatusService storyStatusService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private SprintService sprintService;
    @Autowired
    private EpicService epicService;
    @Autowired
    private UserRepository userRepository;

    public Story createStory(StoryDTO storyDTO){
        StoryStatus storyStatus = storyStatusService.getStoryStatus(storyDTO.getStoryStatus());
        Board board = boardService.getBoard(storyDTO.getBoard());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username).orElseThrow();
        Sprint sprint = sprintService.getSprint(storyDTO.getSprint());
        Epic epic = epicService.getEpic(storyDTO.getEpic());
        Story story = new Story();
        story.setStoryName(storyDTO.getStoryName());
        story.setDescription(storyDTO.getDescription());
        story.setStoryStatus(storyStatus);
        story.setBoard(board);
        story.setUser(user);
        story.setSprint(sprint);
        story.setEpic(epic);
        return storyRepository.save(story);
    }

    public Story updateStoryStatus(UpdateStoryStatusDTO statusDTO, int id){
        Story story = storyRepository.findById(id).orElseThrow();
        StoryStatus storyStatus = storyStatusService.getStoryStatus(statusDTO.getStoryStatusId());
        story.setStoryStatus(storyStatus);
        System.out.println(story.getStoryStatus().getName());
        return storyRepository.save(story);
    }

    public List<Story> getALlStory(){
        return storyRepository.findAll();
    }

    public Story getStory(int id){
        return storyRepository.findById(id).orElseThrow();
    }

    public Story updateStory(StoryDTO storyDTO, int id){
        Story updateStory = storyRepository.findById(id).orElseThrow();
        StoryStatus storyStatus = storyStatusService.getStoryStatus(storyDTO.getStoryStatus());
        Board board = boardService.getBoard(storyDTO.getBoard());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username).orElseThrow();
        Sprint sprint = sprintService.getSprint(storyDTO.getSprint());
        Epic epic = epicService.getEpic(storyDTO.getEpic());
        updateStory.setStoryName(storyDTO.getStoryName());
        updateStory.setDescription(storyDTO.getDescription());
        updateStory.setStoryStatus(storyStatus);
        updateStory.setBoard(board);
        updateStory.setUser(user);
        updateStory.setSprint(sprint);
        updateStory.setEpic(epic);
        return storyRepository.save(updateStory);
    }

    public void deleteStory(int id){
        storyRepository.deleteById(id);
    }

}
