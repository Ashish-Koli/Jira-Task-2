package com.example.jira.services;

import com.example.jira.dto.CommentDTOs.CommentDTO;
import com.example.jira.dto.CommentDTOs.CommentResponseDTO;
import com.example.jira.dto.StoryDTOs.StoryNameResponseDTO;
import com.example.jira.models.Comment;
import com.example.jira.models.Story;
import com.example.jira.repositories.CommentsRepository;
import com.example.jira.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private StoryRepository storyRepository;

    public Comment createComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        Story story = storyRepository.findById(commentDTO.getStory()).orElseThrow();
        comment.setStory(story);
        return commentsRepository.save(comment);
    }

    public List<CommentResponseDTO> getAllComments(int id){
        return commentsRepository.findByStory_StoryId(id).stream().map(comment -> {
            CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
            commentResponseDTO.setCommentId(comment.getCommentId());
            commentResponseDTO.setComment(comment.getComment());
            StoryNameResponseDTO storyNameResponseDTO = new StoryNameResponseDTO();
            storyNameResponseDTO.setStoryId(comment.getStory().getStoryId());
            storyNameResponseDTO.setStoryName(comment.getStory().getStoryName());
            commentResponseDTO.setStory(storyNameResponseDTO);
            return commentResponseDTO;
        }).toList();
    }

    public Comment getComment(int id){
        return commentsRepository.findById(id).orElseThrow();
    }

    public Comment updateComment(CommentDTO commentDTO, int id){
        Comment updateComment = commentsRepository.findById(id).orElseThrow();
        updateComment.setComment(commentDTO.getComment());
        Story updateStory = storyRepository.findById(commentDTO.getStory()).orElseThrow();
        updateComment.setStory(updateStory);
        return commentsRepository.save(updateComment);
    }

    public void deleteComment(int id){
        commentsRepository.deleteById(id);
    }
}
