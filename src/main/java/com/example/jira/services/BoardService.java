package com.example.jira.services;

import com.example.jira.dto.BoardDTOs.BoardDTO;
import com.example.jira.dto.BoardDTOs.BoardResponseDTO;
import com.example.jira.dto.ProjectDTOs.ProjectNamesResponseDTO;
import com.example.jira.models.Board;
import com.example.jira.models.Project;
import com.example.jira.repositories.BoardRepository;
import com.example.jira.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public BoardResponseDTO createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setBoardName(boardDTO.getBoardName());
        Project project = projectRepository.findById(boardDTO.getProject()).orElseThrow();
        board.setProject(project);
        Board board1 = boardRepository.save(board);
        BoardResponseDTO responseDTO = new BoardResponseDTO();
        responseDTO.setBoardId(board1.getBoardId());
        responseDTO.setBoardName(board1.getBoardName());
        ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
        projectNamesResponseDTO.setProjectId(board1.getProject().getProjectId());
        projectNamesResponseDTO.setProjectName(board1.getProject().getProjectName());
        responseDTO.setProject(projectNamesResponseDTO);
        return responseDTO;
    }

    public List<BoardResponseDTO> getAllBoards() {
        return boardRepository.findAll().stream().map(board -> {
                    BoardResponseDTO responseDTO = new BoardResponseDTO();
                    responseDTO.setBoardId(board.getBoardId());
                    responseDTO.setBoardName(board.getBoardName());
                    ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
                    projectNamesResponseDTO.setProjectId(board.getProject().getProjectId());
                    projectNamesResponseDTO.setProjectName(board.getProject().getProjectName());
                    responseDTO.setProject(projectNamesResponseDTO);
                    return responseDTO;
                }
        ).toList();
    }

//    public List<BoardResponseDTO> getBoardsByProjectId(int projectId) {
//        return boardRepository.findBoardsByProjectId(projectId).stream().map(board -> {
//            BoardResponseDTO responseDTO = new BoardResponseDTO();
//            responseDTO.setBoardId(board.getBoardId());
//            responseDTO.setBoardName(board.getBoardName());
//            return responseDTO;
//        }
//        ).toList();
//    }

//    public  List<Board> getBoardsByProjectId(int projectId){
//        return boardRepository.findBoardsByProjectId(projectId);
//    }

    public List<BoardResponseDTO> getBoardsByUserId(int userId) {
        return boardRepository.findBoardsByUserId(userId).stream().map(board -> {
            BoardResponseDTO responseDTO = new BoardResponseDTO();
            responseDTO.setBoardId(board.getBoardId());
            responseDTO.setBoardName(board.getBoardName());
            ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
            projectNamesResponseDTO.setProjectId(board.getProject().getProjectId());
            projectNamesResponseDTO.setProjectName(board.getProject().getProjectName());
            responseDTO.setProject(projectNamesResponseDTO);
            return responseDTO;
        }
        ).toList();
    }
//    public List<Board> getAllBoardsByUserId(int userId) {
//        return boardRepository.findBoardsByUserId(userId);
//    }

    public Board getBoard(int id){
        return boardRepository.findById(id).orElseThrow();
    }

    public BoardResponseDTO updateBoard(BoardDTO boardDTO, int id) {
        Board updateBoard = boardRepository.findById(id).orElseThrow();
        System.out.println(updateBoard.getBoardName());
        System.out.println(boardDTO.getBoardName());
        updateBoard.setBoardName(boardDTO.getBoardName());
        Project project = projectRepository.findById(boardDTO.getProject()).orElseThrow();
        updateBoard.setProject(project);
        Board board1 = boardRepository.save(updateBoard);
        BoardResponseDTO responseDTO = new BoardResponseDTO();
        responseDTO.setBoardId(board1.getBoardId());
        responseDTO.setBoardName(board1.getBoardName());
        ProjectNamesResponseDTO projectNamesResponseDTO = new ProjectNamesResponseDTO();
        projectNamesResponseDTO.setProjectId(board1.getProject().getProjectId());
        projectNamesResponseDTO.setProjectName(board1.getProject().getProjectName());
        responseDTO.setProject(projectNamesResponseDTO);
        return responseDTO;
    }

    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }
}
