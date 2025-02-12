package com.example.jira.dto.StoryDTOs;

public class StoryNameResponseDTO {

    private int storyId;
    private String storyName;

    public StoryNameResponseDTO() {}

    public StoryNameResponseDTO(int storyId, String storyName) {
        this.storyId = storyId;
        this.storyName = storyName;
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
}
