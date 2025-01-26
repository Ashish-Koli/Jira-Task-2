package com.example.jira.models;


import jakarta.persistence.*;

@Entity
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column(name = "TaskName", length = 100)
    private String taskName;

    @Column(name = "Description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "StoryId")
    private Story story;

    public SubTask() {
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

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
