package com.example.jira.dto.responseDTO;


public class BoardNamesResponseDTO {


    private int boardId;
    private String boardName;

    public BoardNamesResponseDTO() {
    }
    public BoardNamesResponseDTO(int boardId, String boardName) {
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
