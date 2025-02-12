package com.example.jira.dto.EpicDTOs;

public class EpicNameResponseDTO {

    private int epicId;
    private String epicName;

    public EpicNameResponseDTO() {
    }

    public EpicNameResponseDTO(int epicId, String epicName) {
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
