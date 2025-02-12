package com.example.jira.dto.SubTaskDTOs;

import com.example.jira.dto.StoryDTOs.StoryNameResponseDTO;

public class SubTaskResponseDTO {
    private int taskId;
    private String taskName;
    private String description;
    private StoryNameResponseDTO story;

    public SubTaskResponseDTO() {}

    public SubTaskResponseDTO(int taskId, String taskName, String description, StoryNameResponseDTO story) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.story = story;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public StoryNameResponseDTO getStory() {
        return story;
    }

    public void setStory(StoryNameResponseDTO story) {
        this.story = story;
    }
}
