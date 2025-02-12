package com.example.jira.dto.BoardDTOs;


import com.example.jira.dto.ProjectDTOs.ProjectNamesResponseDTO;

public class BoardResponseDTO {

    private int boardId;
    private String boardName;
    private ProjectNamesResponseDTO project;

    public BoardResponseDTO() {
    }

    public BoardResponseDTO(int boardId, String boardName, ProjectNamesResponseDTO project) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.project = project;
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

    public ProjectNamesResponseDTO getProject() {
        return project;
    }

    public void setProject(ProjectNamesResponseDTO project) {
        this.project = project;
    }
}
