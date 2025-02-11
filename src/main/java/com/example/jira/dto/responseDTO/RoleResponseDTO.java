package com.example.jira.dto.responseDTO;

import com.example.jira.models.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

public class RoleResponseDTO {

    private int id;
    private String title;

    public RoleResponseDTO() {
    }

    public RoleResponseDTO(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
