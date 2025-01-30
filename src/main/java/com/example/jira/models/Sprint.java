package com.example.jira.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


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

//    @ManyToOne
//    @JoinColumn(name = "epic_id")
//    @JsonBackReference("epic-sprint")
//    private Epic epic;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @JsonIgnore // Prevent recursion
    private Board board;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "sprint-story")
    private List<Story> storyList;

    public Sprint() {
    }

    public Sprint(int sprintId, String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate, Release release, Board board, List<Story> storyList) {
        this.sprintId = sprintId;
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.sprintPoint = sprintPoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.release = release;
        this.board = board;
        this.storyList = storyList;
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

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }
}

