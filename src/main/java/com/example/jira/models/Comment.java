package com.example.jira.models;


import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "Comment", length = 100)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "StoryId")
    private Story story;

    public Comment() {
    }

    public Comment(int commentId, String comment, Story story) {
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

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
