package com.example.jira.services;

import com.example.jira.dto.CommentDTO;
import com.example.jira.models.Comment;
import com.example.jira.models.Story;
import com.example.jira.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private StoryService storyService;

    public Comment createComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        Story story = storyService.getStory(commentDTO.getStory());
        comment.setStory(story);
        return commentsRepository.save(comment);
    }

    public List<Comment> getAllComments(int id){
        return commentsRepository.findByStory_StoryId(id);
    }

    public Comment getComment(int id){
        return commentsRepository.findById(id).orElseThrow();
    }

    public Comment updateComment(CommentDTO commentDTO, int id){
        Comment updateComment = commentsRepository.findById(id).orElseThrow();
        updateComment.setComment(commentDTO.getComment());
        Story updateStory = storyService.getStory(commentDTO.getStory());
        updateComment.setStory(updateStory);
        return commentsRepository.save(updateComment);
    }

    public void deleteComment(int id){
        commentsRepository.deleteById(id);
    }
}
