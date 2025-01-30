package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storyId;

    @Column(name = "StoryName", length = 100)
    private String storyName;

    @Column(name = "Description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "StatusId")
    private StoryStatus storyStatus;

    @ManyToOne
    @JoinColumn(name = "BoardId")
    @JsonIgnore // Prevent recursion

    private Board board;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SprintId")
    @JsonIgnore // Prevent recursion
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name = "EpicId")
    private Epic epic;

    public Story() {
    }

    public Story(int storyId, String storyName, String description, StoryStatus storyStatus, Board board, User user, Sprint sprint, Epic epic) {
        this.storyId = storyId;
        this.storyName = storyName;
        this.description = description;
        this.storyStatus = storyStatus;
        this.board = board;
        this.user = user;
        this.sprint = sprint;
        this.epic = epic;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StoryStatus getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(StoryStatus storyStatus) {
        this.storyStatus = storyStatus;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}