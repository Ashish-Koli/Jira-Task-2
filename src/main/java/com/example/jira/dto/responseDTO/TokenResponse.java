package com.example.jira.dto.responseDTO;

public class TokenResponse {

    private int userId;
    private String role;
    private String token;


    public TokenResponse() {

    }

    public TokenResponse(int userId, String role, String token) {
        this.userId = userId;
        this.role = role;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
