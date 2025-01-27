package com.example.jira.services;

import com.example.jira.dto.ProjectDTO;
import com.example.jira.models.*;
import com.example.jira.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private EpicService epicService;

    public Project createProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());
        List<Board> boardList = new ArrayList<>();
        List<Integer> boardDTOList = projectDTO.getBoardList();
        for (int i=0; i<projectDTO.getBoardList().size(); i++){
            Board board = boardService.getBoard(boardDTOList.get(i));
            if (board != null){
                boardList.add(board);
            }
        }
        project.setBoardList(boardList);

//        List<Epic> epicList = new ArrayList<>();
//        List<Integer> epicDTOList = projectDTO.getEpicList();
//        for (int i = 0; i<projectDTO.getEpicList().size(); i++){
//            Epic epic = epicService.getEpic(epicDTOList.get(i));
//            if (epic != null){
//                epicList.add(epic);
//            }
//        }
//        project.setEpicList(epicList);

        List<User> userList = new ArrayList<>();
        List<Integer> userDTOList = projectDTO.getUserList();
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        project.setUserList(userList);

        return projectRepository.save(project);
    }

    public Project updateProject(ProjectDTO projectDTO, int id){
        Project udpdateProject = projectRepository.findById(id).orElseThrow();
        udpdateProject.setProjectName(projectDTO.getProjectName());
        udpdateProject.setProjectDescription(projectDTO.getProjectDescription());

        List<Board> boardList = new ArrayList<>();
        List<Integer> boardDTOList = projectDTO.getBoardList();
        for (int i=0; i<projectDTO.getBoardList().size(); i++){
            Board board = boardService.getBoard(boardDTOList.get(i));
            if (board != null){
                boardList.add(board);
            }
        }
        udpdateProject.setBoardList(boardList);

//        List<Epic> epicList = new ArrayList<>();
//        List<Integer> epicDTOList = projectDTO.getEpicList();
//        for (int i = 0; i<projectDTO.getEpicList().size(); i++){
//            Epic epic = epicService.getEpic(epicDTOList.get(i));
//            if (epic != null){
//                epicList.add(epic);
//            }
//        }
//        udpdateProject.setEpicList(epicList);

        List<User> userList = new ArrayList<>();
        List<Integer> userDTOList = projectDTO.getUserList();
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        udpdateProject.setUserList(userList);

        return projectRepository.save(udpdateProject);
    }

    public List<Project> getProjectsByUserId(int userId) {
        return projectRepository.findProjectsByUserId(userId);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProject(int id){
        return projectRepository.findById(id).orElseThrow();
    }


    public void deleteProject(int id){
        projectRepository.deleteById(id);
    }
}
