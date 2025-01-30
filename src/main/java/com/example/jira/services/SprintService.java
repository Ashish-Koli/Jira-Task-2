package com.example.jira.services;

import com.example.jira.dto.SprintDTO;
import com.example.jira.models.Board;
import com.example.jira.models.Sprint;
import com.example.jira.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private BoardService boardService;

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

    public List<Sprint> getALlSprint(){
        return sprintRepository.findAll();
    }

    public Sprint getSprint(int id){
        return sprintRepository.findById(id).orElseThrow();
    }

    public List<Sprint> getSprintByBoardId(int id){
        return sprintRepository.findSprintsByBoardId(id);
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
