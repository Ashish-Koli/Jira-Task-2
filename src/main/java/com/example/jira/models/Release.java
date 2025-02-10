package com.example.jira.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "jira_release")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int releaseId;

    @Column(name = "ReleaseName", length = 100)
    private String releaseName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SprintId")
    @JsonIgnore
    private Sprint sprint;

    public Release() {
    }

    public Release(int releaseId, String releaseName, Sprint sprint) {
        this.releaseId = releaseId;
        this.releaseName = releaseName;
        this.sprint = sprint;
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

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}