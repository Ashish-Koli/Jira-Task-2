package com.example.jira.dto.BoardDTOs;

public class BoardNameResponseDTO {

    private int boardId;
    private String boardName;

    public BoardNameResponseDTO() {}

    public BoardNameResponseDTO(int boardId, String boardName) {
        this.boardId = boardId;
        this.boardName = boardName;
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
}
