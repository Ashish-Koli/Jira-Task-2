package com.example.jira.models;

import jakarta.persistence.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private int boardId;

    @Column(name = "BoardName", length = 100)
    private String boardName;

    public Board() {
    }

    public Board(int boardId, String boardName) {
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
