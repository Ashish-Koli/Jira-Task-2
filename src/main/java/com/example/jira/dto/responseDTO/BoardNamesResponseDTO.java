package com.example.jira.dto.responseDTO;


public class BoardNamesResponseDTO {


    private int boardId;
    private String boardName;
    private String project;

    public BoardNamesResponseDTO() {
    }

    public BoardNamesResponseDTO(int boardId, String boardName, String project) {
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
