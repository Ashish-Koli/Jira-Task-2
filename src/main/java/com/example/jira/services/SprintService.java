package com.example.jira.services;

import com.example.jira.dto.BoardDTOs.BoardNameResponseDTO;
import com.example.jira.dto.EpicDTOs.EpicNameResponseDTO;
import com.example.jira.dto.SprintDTOs.SprintDTO;
import com.example.jira.dto.SprintDTOs.SprintResponseDTO;
import com.example.jira.dto.StoryDTOs.StoryResponseDTO;
import com.example.jira.dto.UserDTOs.UserNameResponseDTO;
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
            BoardNameResponseDTO boardNameResponseDTO = new BoardNameResponseDTO();
            boardNameResponseDTO.setBoardId(sprint.getBoard().getBoardId());
            boardNameResponseDTO.setBoardName(sprint.getBoard().getBoardName());
            responseDTO.setBoard(boardNameResponseDTO);
            Release release = releaseService.getReleaseBySprintId(sprint.getSprintId());
            responseDTO.setRelease(release);
            return responseDTO;
        }).toList();
    }

    public Sprint getSprint(int id){
        return sprintRepository.findById(id).orElseThrow();
    }

    public SprintResponseDTO getSprintDetails(int id){
        Sprint sprint = sprintRepository.findById(id).orElseThrow();
        SprintResponseDTO responseDTO =  new SprintResponseDTO();
        responseDTO.setSprintId(sprint.getSprintId());
        responseDTO.setSprintNo(sprint.getSprintNo());
        responseDTO.setSprintName(sprint.getSprintName());
        responseDTO.setSprintPoint(sprint.getSprintPoint());
        responseDTO.setStartDate(sprint.getStartDate());
        responseDTO.setEndDate(sprint.getEndDate());
        BoardNameResponseDTO boardNameResponseDTO = new BoardNameResponseDTO();
        boardNameResponseDTO.setBoardId(sprint.getBoard().getBoardId());
        boardNameResponseDTO.setBoardName(sprint.getBoard().getBoardName());
        responseDTO.setBoard(boardNameResponseDTO);
        Release release = releaseService.getReleaseBySprintId(sprint.getSprintId());
        responseDTO.setRelease(release);
        return responseDTO;
    }


    public List<Sprint> getALlSprint() {
        return sprintRepository.findAll();
    }

    public Map<String, List<StoryResponseDTO>> getCategorizedStoriesBySprintId(int sprintId){
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow();

        List<StoryResponseDTO> todoList = new ArrayList<>();
        List<StoryResponseDTO> doneList = new ArrayList<>();
        List<StoryResponseDTO> inProgressList = new ArrayList<>();
        List<StoryResponseDTO> blockedList = new ArrayList<>();

        for (Story story : sprint.getStoryList()) {
            StoryResponseDTO storyResponseDTO = new StoryResponseDTO();
            storyResponseDTO.setStoryId(story.getStoryId());
            storyResponseDTO.setStoryName(story.getStoryName());
            storyResponseDTO.setDescription(story.getDescription());
            storyResponseDTO.setStoryStatus(story.getStoryStatus());
            UserNameResponseDTO userNameResponseDTO = new UserNameResponseDTO();
            userNameResponseDTO.setUserId(story.getUser().getUserId());
            userNameResponseDTO.setUserName(story.getUser().getUserName());
            storyResponseDTO.setUser(userNameResponseDTO);
            EpicNameResponseDTO epicNameResponseDTO = new EpicNameResponseDTO();
            epicNameResponseDTO.setEpicId(story.getEpic().getEpicId());
            epicNameResponseDTO.setEpicName(story.getEpic().getEpicName());
            storyResponseDTO.setEpic(epicNameResponseDTO);


            if (storyResponseDTO.getStoryStatus().getName().equalsIgnoreCase("ToDo")) {
                todoList.add(storyResponseDTO);
            } else if (storyResponseDTO.getStoryStatus().getName().equalsIgnoreCase("Done")) {
                doneList.add(storyResponseDTO);
            } else if (storyResponseDTO.getStoryStatus().getName().equalsIgnoreCase("InProgress")) {
                inProgressList.add(storyResponseDTO);
            } else if (storyResponseDTO.getStoryStatus().getName().equalsIgnoreCase("Blocked")) {
                blockedList.add(storyResponseDTO);
            }
        }
        Map<String, List<StoryResponseDTO>> categorizedStories = new HashMap<>();
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
