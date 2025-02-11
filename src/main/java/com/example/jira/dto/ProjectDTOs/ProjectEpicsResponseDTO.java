package com.example.jira.dto.ProjectDTOs;

public class ProjectEpicsResponseDTO {

    private int epicId;
    private String epicName;

    public ProjectEpicsResponseDTO() {
    }

    public ProjectEpicsResponseDTO(int epicId, String epicName) {
        this.epicId = epicId;
        this.epicName = epicName;
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
}
