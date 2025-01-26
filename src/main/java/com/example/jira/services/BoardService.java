package com.example.jira.services;

import com.example.jira.dto.BoardDTO;
import com.example.jira.models.Board;
import com.example.jira.models.Project;
import com.example.jira.repositories.BoardRepository;
import com.example.jira.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Board createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setBoardName(boardDTO.getBoardName());
        Project project = projectRepository.findById(boardDTO.getProject()).orElseThrow();
        board.setProject(project);
        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsByProjectId(int projectId) {
        return boardRepository.findBoardsByProjectId(projectId);
    }

    public Board getBoard(int id){
        return boardRepository.findById(id).orElseThrow();
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
