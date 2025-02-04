package com.example.jira.dto.responseDTO;

public class EpicResponseDTO {
    private int epicId;
    private String epicName;
    private String description;
    private String project;

    public EpicResponseDTO() {

    }

    public EpicResponseDTO(int epicId, String epicName, String description, String project) {
        this.epicId = epicId;
        this.epicName = epicName;
        this.description = description;
        this.project = project;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
