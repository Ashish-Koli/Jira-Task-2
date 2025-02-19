package com.example.jira.controllers;

import com.example.jira.dto.BoardDTOs.BoardDTO;
import com.example.jira.dto.BoardDTOs.BoardResponseDTO;
import com.example.jira.services.BoardService;
import com.example.jira.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
//@PreAuthorize("hasAuthority('User')")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardResponseDTO> createBoard(@RequestBody BoardDTO boardDTO){
        return new ResponseEntity<>(boardService.createBoard(boardDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allBoards")
    public ResponseEntity<List<BoardResponseDTO>> getAllBoards(){
        return new ResponseEntity<>(boardService.getAllBoards(), HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable int boardId){
        return new ResponseEntity<>(boardService.getBoard(boardId), HttpStatus.OK);
    }

//    @GetMapping("/project/{projectId}")
//    public ResponseEntity<List<Board>> getBoardsByProjectId(@PathVariable int projectId) {
//        return new ResponseEntity<>(boardService.getBoardsByProjectId(projectId),HttpStatus.OK);
//    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BoardResponseDTO>> getBoardsByUserId(@PathVariable int userId) {
        return new ResponseEntity<>(boardService.getBoardsByUserId(userId),HttpStatus.OK);
    }

//    @GetMapping("/allBoards/user/{userId}")
//    public ResponseEntity<List<Board>> getAllBoardsByUserId(@PathVariable int userId) {
//        return new ResponseEntity<>(boardService.getAllBoardsByUserId(userId),HttpStatus.OK);
//    }


    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponseDTO> updateBoard(@RequestBody BoardDTO boardDTO, @PathVariable int boardId){
        return new ResponseEntity<>(boardService.updateBoard(boardDTO, boardId), HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable int boardId){
        boardService.deleteBoard(boardId);
        return new ResponseEntity<>("Board Deleted.",HttpStatus.NO_CONTENT);
    }

}
