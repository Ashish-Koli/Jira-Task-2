package com.example.jira.dto.SubTaskDTOs;

public class SubTaskDTO {

    private String taskName;
    private String description;
    private int story;

    public SubTaskDTO(String taskName, String description, int story) {
        this.taskName = taskName;
        this.description = description;
        this.story = story;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }
}
