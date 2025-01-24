package com.example.jira.services;

import com.example.jira.models.Board;
import com.example.jira.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board updateBoard(Board board, int id) {
        Board updateBoard = boardRepository.findById(id).orElseThrow();
        updateBoard.setBoardName(board.getBoardName());
        return boardRepository.save(updateBoard);
    }

    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }
}
