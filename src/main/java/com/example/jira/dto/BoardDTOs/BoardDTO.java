package com.example.jira.dto.BoardDTOs;


public class BoardDTO {

    private String boardName;
    private int project;

    public BoardDTO(String boardName, int project) {
        this.boardName = boardName;
        this.project = project;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }
}
