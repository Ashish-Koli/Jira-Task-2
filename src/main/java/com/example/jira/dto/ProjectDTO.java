package com.example.jira.dto;

import java.util.List;

public class ProjectDTO {

    private String projectName;
    private String projectDescription;
    private List<Integer> boardList;
    private List<Integer> userList;

    public ProjectDTO(String projectName, String projectDescription, List<Integer> boardList, List<Integer> userList) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.boardList = boardList;
        this.userList = userList;
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

    public List<Integer> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Integer> boardList) {
        this.boardList = boardList;
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public void setUserList(List<Integer> userList) {
        this.userList = userList;
    }
}
