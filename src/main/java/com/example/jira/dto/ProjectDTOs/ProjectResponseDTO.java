package com.example.jira.dto.ProjectDTOs;


import com.example.jira.models.Board;
import com.example.jira.models.Epic;
import com.example.jira.models.User;

import java.util.List;

public class ProjectResponseDTO {

    private int projectId;
    private String projectName;
    private String projectDescription;
    private List<ProjectBoardsResponseDTO> boardList;
    private List<ProjectEpicsResponseDTO> epicList;
    private List<ProjectUsersResponseDTO> userList;

    public ProjectResponseDTO() {
    }

    public ProjectResponseDTO(int projectId, String projectName, String projectDescription, List<ProjectBoardsResponseDTO> boardList, List<ProjectEpicsResponseDTO> epicList, List<ProjectUsersResponseDTO> userList) {
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

    public List<ProjectBoardsResponseDTO> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<ProjectBoardsResponseDTO> boardList) {
        this.boardList = boardList;
    }

    public List<ProjectEpicsResponseDTO> getEpicList() {
        return epicList;
    }

    public void setEpicList(List<ProjectEpicsResponseDTO> epicList) {
        this.epicList = epicList;
    }

    public List<ProjectUsersResponseDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<ProjectUsersResponseDTO> userList) {
        this.userList = userList;
    }
}
