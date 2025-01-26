package com.example.jira.dto;

public class StoryDTO {

    private String storyName;
    private String description;
    private int storyStatus;
    private int board;
    private int user;
    private int sprint;
    private int epic;

    public StoryDTO(String storyName, String description, int storyStatus, int board, int user, int sprint, int epic) {
        this.storyName = storyName;
        this.description = description;
        this.storyStatus = storyStatus;
        this.board = board;
        this.user = user;
        this.sprint = sprint;
        this.epic = epic;
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

    public int getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(int storyStatus) {
        this.storyStatus = storyStatus;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getSprint() {
        return sprint;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }

    public int getEpic() {
        return epic;
    }

    public void setEpic(int epic) {
        this.epic = epic;
    }
}
