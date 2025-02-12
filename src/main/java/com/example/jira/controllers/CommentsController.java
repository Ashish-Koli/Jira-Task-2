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
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentsService.createComment(commentDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/allComment")
//    public ResponseEntity<List<Comment>> getAllComments(){
//        return new ResponseEntity<>(commentsService.getAllComments(), HttpStatus.OK);
//    }
    @GetMapping("/allComment/{id}")
    public ResponseEntity<List<CommentResponseDTO>> getAllComments(@PathVariable int id) {
        return new ResponseEntity<>(commentsService.getAllComments(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable int id){
        return new ResponseEntity<>(commentsService.getComment(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentDTO commentDTO , @PathVariable int id){
        return new ResponseEntity<>(commentsService.updateComment(commentDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable int id){
        commentsService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
