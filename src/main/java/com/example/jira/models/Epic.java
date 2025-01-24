package com.example.jira.models;


import jakarta.persistence.*;

@Entity
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int epicId;

    @Column(name = "EpicName", length = 100)
    private String epicName;

    @Column(name = "Description", length = 255)
    private String description;

    public Epic() {
    }

    public Epic(int epicId, String epicName, String description) {
        this.epicId = epicId;
        this.epicName = epicName;
        this.description = description;
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
}
