package com.example.jira.dto.ProjectDTOs;

public class ProjectUsersResponseDTO {

    private int userId;
    private String userName;

    public ProjectUsersResponseDTO() {
    }

    public ProjectUsersResponseDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
