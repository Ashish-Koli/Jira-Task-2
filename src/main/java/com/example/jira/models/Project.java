package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    @Column(name = "ProjectName", length = 100)
    private String projectName;
    @Column(name = "ProjectDescription", length = 100)
    private String projectDescription;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "project-board")
    private List<Board> boardList;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "project-epic")
    private List<Epic> epicList;

    @ManyToMany
    @JoinTable(
            name = "project_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonManagedReference(value = "project-user")
    private List<User> userList;

    public Project() {
    }

    public Project(int projectId, String projectName, String projectDescription, List<Board> boardList, List<Epic> epicList, List<User> userList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.boardList = boardList;
        this.epicList = epicList;
        this.userList = userList;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    public List<Epic> getEpicList() {
        return epicList;
    }

    public void setEpicList(List<Epic> epicList) {
        this.epicList = epicList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
