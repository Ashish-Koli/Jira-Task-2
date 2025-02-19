package com.example.jira.controllers;

import com.example.jira.dto.CommentDTOs.CommentDTO;
import com.example.jira.dto.CommentDTOs.CommentResponseDTO;
import com.example.jira.models.Comment;
import com.example.jira.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentsService.createComment(commentDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/allComment")
//    public ResponseEntity<List<Comment>> getAllComments(){
//        return new ResponseEntity<>(commentsService.getAllComments(), HttpStatus.OK);
//    }
    @GetMapping("/allComments/{storyId}")
    public ResponseEntity<List<CommentResponseDTO>> getAllComments(@PathVariable int storyId) {
        return new ResponseEntity<>(commentsService.getAllComments(storyId), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable int commentId){
        return new ResponseEntity<>(commentsService.getComment(commentId), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentDTO commentDTO , @PathVariable int commentId){
        return new ResponseEntity<>(commentsService.updateComment(commentDTO, commentId), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable int commentId){
        commentsService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
