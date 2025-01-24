package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;




@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "UserName", length = 100)
    private String userName;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Password", length = 50)
    private String password;
    @ManyToOne
    @JoinColumn(name = "RoleId")
    @JsonBackReference
    private Role role;

    public User() {
    }

    public User(int userId, String userName, String email, String password, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}