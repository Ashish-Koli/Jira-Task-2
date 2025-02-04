package com.example.jira.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int epicId;

    @Column(name = "EpicName", length = 100)
    private String epicName;

    @Column(name = "Description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference(value = "project-epic")
    private Project project;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<Story> story;

//    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
//    @JsonManagedReference("epic-sprint")
//    private List<Sprint> sprintList;



    public Epic() {
    }

    public Epic(int epicId, String epicName, String description, Project project) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
