package com.example.jira.services;

import com.example.jira.dto.ProjectDTO;
import com.example.jira.dto.responseDTO.ProjectNamesResponseDTO;
import com.example.jira.models.*;
import com.example.jira.repositories.ProjectRepository;
import com.example.jira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;



    public Project createProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());
        List<Board> boardList = new ArrayList<>();
//        List<Integer> boardDTOList = projectDTO.getBoardList();
//        for (int i=0; i<projectDTO.getBoardList().size(); i++){
//            Board board = boardService.getBoard(boardDTOList.get(i));
//            if (board != null){
//                boardList.add(board);
//            }
//        }
        project.setBoardList(boardList);

        List<Epic> epicList = new ArrayList<>();
//        List<Integer> epicDTOList = projectDTO.getEpicList();
//        for (int i = 0; i<projectDTO.getEpicList().size(); i++){
//            Epic epic = epicService.getEpic(epicDTOList.get(i));
//            if (epic != null){
//                epicList.add(epic);
//            }
//        }
        project.setEpicList(epicList);

        List<User> userList = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        String username = "Ashish";
        User user1 = userRepository.findByUserName(username);
        userList.add(user1); // add the current user
        List<Integer> userDTOList = projectDTO.getUserList();
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        System.out.println(userList);
        project.setUserList(userList);

        return projectRepository.save(project);
    }

    public Project updateProject(ProjectDTO projectDTO, int id){
        Project updateProject = projectRepository.findById(id).orElseThrow();
        updateProject.setProjectName(projectDTO.getProjectName());
        updateProject.setProjectDescription(projectDTO.getProjectDescription());
//
//        List<Board> boardList = new ArrayList<>();
//        List<Integer> boardDTOList = projectDTO.getBoardList();
//        for (int i=0; i<projectDTO.getBoardList().size(); i++){
//            Board board = boardService.getBoard(boardDTOList.get(i));
//            if (board != null){
//                boardList.add(board);
//            }
//        }
        updateProject.setBoardList(updateProject.getBoardList());
//
////        List<Epic> epicList = new ArrayList<>();
////        List<Integer> epicDTOList = projectDTO.getEpicList();
////        for (int i = 0; i<projectDTO.getEpicList().size(); i++){
////            Epic epic = epicService.getEpic(epicDTOList.get(i));
////            if (epic != null){
////                epicList.add(epic);
////            }
////        }
        updateProject.setEpicList(updateProject.getEpicList());
//
        List<User> userList = new ArrayList<>();
        List<Integer> userDTOList = projectDTO.getUserList();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        String username = "Ashish";
        User user1 = userRepository.findByUserName(username);
        userList.add(user1); // add the current user
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        updateProject.setUserList(userList);

        return projectRepository.save(updateProject);
    }

    public List<Project> getProjectsByUserId(int userId) {
        return projectRepository.findProjectsByUserId(userId);
    }

    public List<ProjectNamesResponseDTO> getProjectsNamesByUserId(int id){
       return projectRepository.findProjectsByUserId(id).stream().map((project -> {
            ProjectNamesResponseDTO namesResponseDTO = new ProjectNamesResponseDTO();
            namesResponseDTO.setProjectId(project.getProjectId());
            namesResponseDTO.setProjectName(project.getProjectName());
            return namesResponseDTO;
        })).toList();
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
