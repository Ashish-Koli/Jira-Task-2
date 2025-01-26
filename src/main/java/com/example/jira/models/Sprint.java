package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sprintId;

    @Column(name = "SprintNo", length = 100)
    private String sprintNo;

    @Column(name = "SprintName", length = 255)
    private String sprintName;

    @Column(name = "SprintPoint")
    private int sprintPoint;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @OneToOne(mappedBy = "sprint", cascade = CascadeType.ALL)
    private Release release;

    @ManyToOne
    @JoinColumn(name = "epic_id")
    @JsonBackReference("epic-sprint")
    private Epic epic;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @JsonBackReference("board-sprint")
    private Board board;

    public Sprint() {
    }

    public Sprint(int sprintId, String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate) {
        this.sprintId = sprintId;
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.sprintPoint = sprintPoint;
        this.startDate = startDate;
        this.endDate = endDate;
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
}

