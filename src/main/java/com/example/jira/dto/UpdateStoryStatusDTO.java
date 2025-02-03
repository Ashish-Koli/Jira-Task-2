package com.example.jira.dto;


public class UpdateStoryStatusDTO {

    private int storyStatusId;

    public UpdateStoryStatusDTO(int storyStatusId) {
        this.storyStatusId = storyStatusId;
    }


    public int getStoryStatusId() {
        return storyStatusId;
    }

    public void setStoryStatusId(int storyStatusId) {
        this.storyStatusId = storyStatusId;
    }
}
