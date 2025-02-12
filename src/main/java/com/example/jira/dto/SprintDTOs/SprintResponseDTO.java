package com.example.jira.dto.SprintDTOs;

import com.example.jira.dto.BoardDTOs.BoardNameResponseDTO;
import com.example.jira.models.Release;

import java.util.Date;

public class SprintResponseDTO {
    private int sprintId;
    private String sprintNo;
    private String sprintName;
    private int sprintPoint;
    private Date startDate;
    private Date endDate;
    private BoardNameResponseDTO board;
    private Release release;

    public SprintResponseDTO() {
    }

    public SprintResponseDTO(int sprintId, String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate, BoardNameResponseDTO board, Release release) {
        this.sprintId = sprintId;
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.sprintPoint = sprintPoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.board = board;
        this.release = release;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintNo() {
        return sprintNo;
    }

    public void setSprintNo(String sprintNo) {
        this.sprintNo = sprintNo;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public int getSprintPoint() {
        return sprintPoint;
    }

    public void setSprintPoint(int sprintPoint) {
        this.sprintPoint = sprintPoint;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BoardNameResponseDTO getBoard() {
        return board;
    }

    public void setBoard(BoardNameResponseDTO board) {
        this.board = board;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }
}
