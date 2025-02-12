package com.example.jira.dto.SprintDTOs;

public class SprintNameResponseDTO {
    private int sprintId;
    private String sprintName;

    public SprintNameResponseDTO() {
    }

    public SprintNameResponseDTO(int sprintId, String sprintName) {
        this.sprintId = sprintId;
        this.sprintName = sprintName;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }
}
