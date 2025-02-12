package com.example.jira.dto.StoryDTOs;

import com.example.jira.dto.BoardDTOs.BoardNameResponseDTO;
import com.example.jira.dto.EpicDTOs.EpicNameResponseDTO;
import com.example.jira.dto.SprintDTOs.SprintNameResponseDTO;
import com.example.jira.dto.UserDTOs.UserNameResponseDTO;
import com.example.jira.models.StoryStatus;

public class StoryResponseDTO {
    private int storyId;
    private String storyName;
    private String description;
    private StoryStatus storyStatus;
    private BoardNameResponseDTO board;
    private SprintNameResponseDTO sprint;
    private EpicNameResponseDTO epic;
    private UserNameResponseDTO user;

    public StoryResponseDTO() {
    }

    public StoryResponseDTO(int storyId, String storyName, String description, StoryStatus storyStatus, BoardNameResponseDTO board, SprintNameResponseDTO sprint, EpicNameResponseDTO epic) {
        this.storyId = storyId;
        this.storyName = storyName;
        this.description = description;
        this.storyStatus = storyStatus;
        this.board = board;
        this.sprint = sprint;
        this.epic = epic;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StoryStatus getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(StoryStatus storyStatus) {
        this.storyStatus = storyStatus;
    }

    public BoardNameResponseDTO getBoard() {
        return board;
    }

    public void setBoard(BoardNameResponseDTO board) {
        this.board = board;
    }

    public SprintNameResponseDTO getSprint() {
        return sprint;
    }

    public void setSprint(SprintNameResponseDTO sprint) {
        this.sprint = sprint;
    }

    public EpicNameResponseDTO getEpic() {
        return epic;
    }

    public void setEpic(EpicNameResponseDTO epic) {
        this.epic = epic;
    }

    public UserNameResponseDTO getUser() {
        return user;
    }

    public void setUser(UserNameResponseDTO user) {
        this.user = user;
    }
}
