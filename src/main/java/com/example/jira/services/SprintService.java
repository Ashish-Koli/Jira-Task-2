package com.example.jira.services;

import com.example.jira.dto.SprintDTO;
import com.example.jira.dto.responseDTO.SprintResponseDTO;
import com.example.jira.models.Board;
import com.example.jira.models.Release;
import com.example.jira.models.Sprint;
import com.example.jira.models.Story;
import com.example.jira.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReleaseService releaseService;

    public Sprint createSprint(SprintDTO sprintDTO){
        Sprint sprint = new Sprint();
        sprint.setSprintNo(sprintDTO.getSprintNo());
        sprint.setSprintName(sprintDTO.getSprintName());
        sprint.setSprintPoint(sprintDTO.getSprintPoint());
        sprint.setStartDate(sprintDTO.getStartDate());
        sprint.setEndDate(sprintDTO.getEndDate());
        Board board = boardService.getBoard(sprintDTO.getBoard());
        sprint.setBoard(board);
        return sprintRepository.save(sprint);
    }

    public List<Sprint> getSprintByBoardId(int id){
        return sprintRepository.findSprintsByBoardId(id);
    }

    public List<SprintResponseDTO> getSprintByUserId(int id){
        return sprintRepository.findSprintsByUserId(id).stream().map(sprint -> {
            SprintResponseDTO responseDTO =  new SprintResponseDTO();
            responseDTO.setSprintId(sprint.getSprintId());
            responseDTO.setSprintNo(sprint.getSprintNo());
            responseDTO.setSprintName(sprint.getSprintName());
            responseDTO.setSprintPoint(sprint.getSprintPoint());
            responseDTO.setStartDate(sprint.getStartDate());
            responseDTO.setEndDate(sprint.getEndDate());
            responseDTO.setBoard(sprint.getBoard().getBoardName());
            Release release = releaseService.getReleaseBySprintId(sprint.getSprintId());
            responseDTO.setReleaseId(release.getReleaseId());
            responseDTO.setReleaseName(release.getReleaseName());
            return responseDTO;
        }).toList();
    }

    public Sprint getSprint(int id){
        return sprintRepository.findById(id).orElseThrow();
    }

//    public List<SprintResponseDTO> getALlSprint(){
//        return sprintRepository.findAll().stream().map(sprint -> {
//            SprintResponseDTO responseDTO =  new SprintResponseDTO();
//            responseDTO.setSprintId(sprint.getSprintId());
//            responseDTO.setSprintNo(sprint.getSprintNo());
//            responseDTO.setSprintName(sprint.getSprintName());
//            responseDTO.setSprintPoint(sprint.getSprintPoint());
//            responseDTO.setStartDate(sprint.getStartDate());
//            responseDTO.setEndDate(sprint.getEndDate());
//            responseDTO.setBoard(sprint.getBoard().getBoardName());
//            return responseDTO;
//        }).toList();
//    }


    public List<Sprint> getALlSprint() {
        return sprintRepository.findAll();
    }

    public Map<String, List<Story>> getCategorizedStoriesBySprintId(int sprintId){
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow();

        List<Story> todoList = new ArrayList<>();
        List<Story> doneList = new ArrayList<>();
        List<Story> inProgressList = new ArrayList<>();
        List<Story> blockedList = new ArrayList<>();

        for (Story story : sprint.getStoryList()) {
            if (story.getStoryStatus().getName().equalsIgnoreCase("ToDo")) {
                todoList.add(story);
            } else if (story.getStoryStatus().getName().equalsIgnoreCase("Done")) {
                doneList.add(story);
            } else if (story.getStoryStatus().getName().equalsIgnoreCase("InProgress")) {
                inProgressList.add(story);
            } else if (story.getStoryStatus().getName().equalsIgnoreCase("Blocked")) {
                blockedList.add(story);
            }
        }
        Map<String, List<Story>> categorizedStories = new HashMap<>();
        categorizedStories.put("ToDo", todoList);
        categorizedStories.put("Done", doneList);
        categorizedStories.put("InProgress", inProgressList);
        categorizedStories.put("Blocked", blockedList);

        return categorizedStories;
    }

    public Sprint updateSprint(SprintDTO sprintDTO, int id){
        Sprint updateSprint = sprintRepository.findById(id).orElseThrow();
        updateSprint.setSprintNo(sprintDTO.getSprintNo());
        updateSprint.setSprintName(sprintDTO.getSprintName());
        updateSprint.setSprintPoint(sprintDTO.getSprintPoint());
        updateSprint.setStartDate(sprintDTO.getStartDate());
        updateSprint.setEndDate(sprintDTO.getEndDate());
        Board board = boardService.getBoard(sprintDTO.getBoard());
        updateSprint.setBoard(board);
        return sprintRepository.save(updateSprint);
    }

    public void deleteSprint(int id){
        sprintRepository.deleteById(id);
    }


}
