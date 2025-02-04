package com.example.jira.dto;



public class EpicDTO {
    private String epicName;
    private String description;
    private int project;

    public EpicDTO(String epicName, String description, int project) {
        this.epicName = epicName;
        this.description = description;
        this.project = project;
    }

    public String getEpicName() {
        return epicName;
    }

    public void setEpicName(String epicName) {
        this.epicName = epicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }
}
