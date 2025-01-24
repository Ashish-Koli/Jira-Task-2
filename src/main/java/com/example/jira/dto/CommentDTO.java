package com.example.jira.dto;

public class CommentDTO {

    private String comment;
    private int story;

    public CommentDTO(String comment, int story){
        this.comment = comment;
        this.story = story;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }
}
