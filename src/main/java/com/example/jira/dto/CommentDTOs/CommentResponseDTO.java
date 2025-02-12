package com.example.jira.dto.CommentDTOs;

import com.example.jira.dto.StoryDTOs.StoryNameResponseDTO;

public class CommentResponseDTO {
    private int commentId;
    private String comment;
    private StoryNameResponseDTO story;

    public CommentResponseDTO() {
    }

    public CommentResponseDTO(int commentId, String comment, StoryNameResponseDTO story) {
        this.commentId = commentId;
        this.comment = comment;
        this.story = story;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StoryNameResponseDTO getStory() {
        return story;
    }

    public void setStory(StoryNameResponseDTO story) {
        this.story = story;
    }
}
