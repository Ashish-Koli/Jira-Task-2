package com.example.jira.dto.UserDTOs;

import com.example.jira.dto.responseDTO.RoleResponseDTO;

public class UserResponseDTO {
    private int userId;
    private String userName;
    private String email;
    private RoleResponseDTO role;

    public UserResponseDTO(){}

    public UserResponseDTO(int userId, String userName, String email, RoleResponseDTO role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleResponseDTO getRole() {
        return role;
    }

    public void setRole(RoleResponseDTO role) {
        this.role = role;
    }
}
