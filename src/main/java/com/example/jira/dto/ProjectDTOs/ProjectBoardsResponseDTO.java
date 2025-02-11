package com.example.jira.dto.ProjectDTOs;

import com.example.jira.models.Sprint;

import java.util.List;

public class ProjectBoardsResponseDTO {

    private int boardId;
    private String boardName;
    private List<ProjectBoardSprintsResponseDTO> sprintList;

    public ProjectBoardsResponseDTO() {
    }

    public ProjectBoardsResponseDTO(int boardId, String boardName, List<ProjectBoardSprintsResponseDTO> sprintList) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.sprintList = sprintList;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<ProjectBoardSprintsResponseDTO> getSprintList() {
        return sprintList;
    }

    public void setSprintList(List<ProjectBoardSprintsResponseDTO> sprintList) {
        this.sprintList = sprintList;
    }
}
