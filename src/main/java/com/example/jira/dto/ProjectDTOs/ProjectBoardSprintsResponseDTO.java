package com.example.jira.dto.ProjectDTOs;

public class ProjectBoardSprintsResponseDTO {

    private int sprintId;
    private String sprintName;

    public ProjectBoardSprintsResponseDTO() {
    }

    public ProjectBoardSprintsResponseDTO(int sprintId, String sprintName) {
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
