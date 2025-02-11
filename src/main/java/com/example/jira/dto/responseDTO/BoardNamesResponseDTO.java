package com.example.jira.dto.responseDTO;


public class BoardNamesResponseDTO {


    private int boardId;
    private String boardName;
    private int projectId;
    private String project;

    public BoardNamesResponseDTO() {
    }

    public BoardNamesResponseDTO(int boardId, String boardName, int projectId, String project) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.projectId = projectId;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
