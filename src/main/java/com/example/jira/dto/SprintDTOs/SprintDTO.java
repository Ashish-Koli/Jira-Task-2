package com.example.jira.dto.SprintDTOs;
import java.util.Date;

public class SprintDTO {
    private String sprintNo;
    private String sprintName;
    private int sprintPoint;
    private Date startDate;
    private Date endDate;
    private int board;

    public SprintDTO(String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate, int board) {
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.sprintPoint = sprintPoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.board = board;
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

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }
}
