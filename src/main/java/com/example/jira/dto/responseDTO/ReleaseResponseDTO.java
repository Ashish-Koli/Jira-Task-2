package com.example.jira.dto.responseDTO;

import com.example.jira.models.Sprint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class ReleaseResponseDTO {

        private int releaseId;
        private String releaseName;
        private int sprintId;
        private String sprintName;

    public ReleaseResponseDTO(int releaseId, String releaseName, int sprintId, String sprintName) {
        this.releaseId = releaseId;
        this.releaseName = releaseName;
        this.sprintId = sprintId;
        this.sprintName = sprintName;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
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
