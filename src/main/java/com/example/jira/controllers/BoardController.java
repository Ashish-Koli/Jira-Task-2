package com.example.jira.controllers;

import com.example.jira.Services.BoardService;
import com.example.jira.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    public ResponseEntity<Board> createBoard(@RequestBody Board board){
        return new ResponseEntity<>(boardService.createBoard(board), HttpStatus.CREATED);
    }



}
