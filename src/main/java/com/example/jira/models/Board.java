package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int boardId;

    @Column(name = "BoardName", length = 100)
    private String boardName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference(value = "project-board")
    private Project project;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @JsonManagedReference("board-sprint")
    private List<Sprint> sprintList;

    public Board() {
    }

    public Board(int boardId, String boardName, Project project) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
