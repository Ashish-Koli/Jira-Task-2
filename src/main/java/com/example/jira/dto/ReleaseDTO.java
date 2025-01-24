package com.example.jira.dto;

public class ReleaseDTO {

    private String releaseName;
    private int sprint;

    public ReleaseDTO(String releaseName, int sprint) {
        this.releaseName = releaseName;
        this.sprint = sprint;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public int getSprint() {
        return sprint;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }
}
