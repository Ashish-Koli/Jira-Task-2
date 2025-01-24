package com.example.jira.controllers;

import com.example.jira.services.BoardService;
import com.example.jira.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Board> createBoard(@RequestBody Board board){
        return new ResponseEntity<>(boardService.createBoard(board), HttpStatus.CREATED);
    }

    @GetMapping("/allBoards")
    public ResponseEntity<List<Board>> getAllBoards(){
        return new ResponseEntity<>(boardService.getAllBoards(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Board> updateBoard(@RequestBody Board board, @PathVariable int id){
        return new ResponseEntity<>(boardService.updateBoard(board, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id){
        boardService.deleteBoard(id);
        return new ResponseEntity<>("Board Deleted.",HttpStatus.NO_CONTENT);
    }

}
