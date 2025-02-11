package com.example.jira.services;

import com.example.jira.dto.ProjectDTO;
import com.example.jira.dto.ProjectDTOs.*;
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



    public ProjectResponseDTO createProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());
        List<Board> boardList = new ArrayList<>();
        project.setBoardList(boardList);
        List<Epic> epicList = new ArrayList<>();
        project.setEpicList(epicList);
        List<User> userList = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user1 = userRepository.findByUserName(username).orElseThrow();
        userList.add(user1);
        List<Integer> userDTOList = projectDTO.getUserList();
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        System.out.println(userList);
        project.setUserList(userList);
        projectRepository.save(project);


        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setProjectId(project.getProjectId());
        projectResponseDTO.setProjectName(project.getProjectName());
        projectResponseDTO.setProjectDescription(project.getProjectDescription());

        List<ProjectBoardsResponseDTO> boardList1 =  project.getBoardList().stream().map((board)->{
            ProjectBoardsResponseDTO projectBoardsResponseDTO = new ProjectBoardsResponseDTO();
            projectBoardsResponseDTO.setBoardId(board.getBoardId());
            projectBoardsResponseDTO.setBoardName(board.getBoardName());
            List<ProjectBoardSprintsResponseDTO> sprintList =  board.getSprintList().stream().map((sprint)->{
                ProjectBoardSprintsResponseDTO projectBoardSprintsResponseDTO = new ProjectBoardSprintsResponseDTO();
                projectBoardSprintsResponseDTO.setSprintId(sprint.getSprintId());
                projectBoardSprintsResponseDTO.setSprintName(sprint.getSprintName());
                return projectBoardSprintsResponseDTO;
            }).toList();
            projectBoardsResponseDTO.setSprintList(sprintList);
            return projectBoardsResponseDTO;
        }).toList();
        projectResponseDTO.setBoardList(boardList1);

        List<ProjectEpicsResponseDTO> epicList1 = project.getEpicList().stream().map((epic)->{
            ProjectEpicsResponseDTO projectEpicsResponseDTO = new ProjectEpicsResponseDTO();
            projectEpicsResponseDTO.setEpicId(epic.getEpicId());
            projectEpicsResponseDTO.setEpicName(epic.getEpicName());
            return projectEpicsResponseDTO;
        }).toList();
        projectResponseDTO.setEpicList(epicList1);

        List<ProjectUsersResponseDTO> userList1 = project.getUserList().stream().map((user)->{
            ProjectUsersResponseDTO projectUsersResponseDTO = new ProjectUsersResponseDTO();
            projectUsersResponseDTO.setUserId(user.getUserId());
            projectUsersResponseDTO.setUserName(user.getUserName());
            return projectUsersResponseDTO;
        }).toList();
        projectResponseDTO.setUserList(userList1);

        return projectResponseDTO;

    } // change this

    public Project getProject(int id){
        return projectRepository.findById(id).orElseThrow();
    }

    public List<ProjectResponseDTO> getAllProjects(){
        return projectRepository.findAll().stream().map((project)->{
            ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
            projectResponseDTO.setProjectId(project.getProjectId());
            projectResponseDTO.setProjectName(project.getProjectName());
            projectResponseDTO.setProjectDescription(project.getProjectDescription());

            List<ProjectBoardsResponseDTO> boardList =  project.getBoardList().stream().map((board)->{
                ProjectBoardsResponseDTO projectBoardsResponseDTO = new ProjectBoardsResponseDTO();
                projectBoardsResponseDTO.setBoardId(board.getBoardId());
                projectBoardsResponseDTO.setBoardName(board.getBoardName());
                List<ProjectBoardSprintsResponseDTO> sprintList =  board.getSprintList().stream().map((sprint)->{
                    ProjectBoardSprintsResponseDTO projectBoardSprintsResponseDTO = new ProjectBoardSprintsResponseDTO();
                    projectBoardSprintsResponseDTO.setSprintId(sprint.getSprintId());
                    projectBoardSprintsResponseDTO.setSprintName(sprint.getSprintName());
                    return projectBoardSprintsResponseDTO;
                }).toList();
                projectBoardsResponseDTO.setSprintList(sprintList);
                return projectBoardsResponseDTO;
            }).toList();
            projectResponseDTO.setBoardList(boardList);

            List<ProjectEpicsResponseDTO> epicList = project.getEpicList().stream().map((epic)->{
                ProjectEpicsResponseDTO projectEpicsResponseDTO = new ProjectEpicsResponseDTO();
                projectEpicsResponseDTO.setEpicId(epic.getEpicId());
                projectEpicsResponseDTO.setEpicName(epic.getEpicName());
                return projectEpicsResponseDTO;
            }).toList();
            projectResponseDTO.setEpicList(epicList);

            List<ProjectUsersResponseDTO> userList = project.getUserList().stream().map((user)->{
                ProjectUsersResponseDTO projectUsersResponseDTO = new ProjectUsersResponseDTO();
                projectUsersResponseDTO.setUserId(user.getUserId());
                projectUsersResponseDTO.setUserName(user.getUserName());
                return projectUsersResponseDTO;
            }).toList();
            projectResponseDTO.setUserList(userList);

            return projectResponseDTO;
        }).toList();
    }

    public List<ProjectResponseDTO> getProjectsByUserId(int userId) {
        return projectRepository.findProjectsByUserId(userId).stream().map((project)->{
            ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
            projectResponseDTO.setProjectId(project.getProjectId());
            projectResponseDTO.setProjectName(project.getProjectName());
            projectResponseDTO.setProjectDescription(project.getProjectDescription());

            List<ProjectBoardsResponseDTO> boardList =  project.getBoardList().stream().map((board)->{
                ProjectBoardsResponseDTO projectBoardsResponseDTO = new ProjectBoardsResponseDTO();
                projectBoardsResponseDTO.setBoardId(board.getBoardId());
                projectBoardsResponseDTO.setBoardName(board.getBoardName());
                List<ProjectBoardSprintsResponseDTO> sprintList =  board.getSprintList().stream().map((sprint)->{
                    ProjectBoardSprintsResponseDTO projectBoardSprintsResponseDTO = new ProjectBoardSprintsResponseDTO();
                    projectBoardSprintsResponseDTO.setSprintId(sprint.getSprintId());
                    projectBoardSprintsResponseDTO.setSprintName(sprint.getSprintName());
                    return projectBoardSprintsResponseDTO;
                }).toList();
                projectBoardsResponseDTO.setSprintList(sprintList);
                return projectBoardsResponseDTO;
            }).toList();
            projectResponseDTO.setBoardList(boardList);

            List<ProjectEpicsResponseDTO> epicList = project.getEpicList().stream().map((epic)->{
                ProjectEpicsResponseDTO projectEpicsResponseDTO = new ProjectEpicsResponseDTO();
                projectEpicsResponseDTO.setEpicId(epic.getEpicId());
                projectEpicsResponseDTO.setEpicName(epic.getEpicName());
                return projectEpicsResponseDTO;
            }).toList();
            projectResponseDTO.setEpicList(epicList);

            List<ProjectUsersResponseDTO> userList = project.getUserList().stream().map((user)->{
                ProjectUsersResponseDTO projectUsersResponseDTO = new ProjectUsersResponseDTO();
                projectUsersResponseDTO.setUserId(user.getUserId());
                projectUsersResponseDTO.setUserName(user.getUserName());
                return projectUsersResponseDTO;
            }).toList();
            projectResponseDTO.setUserList(userList);

            return projectResponseDTO;
        }).toList();
    }

    public List<ProjectNamesResponseDTO> getProjectsNamesByUserId(int id){
        return projectRepository.findProjectsByUserId(id).stream().map((project -> {
            ProjectNamesResponseDTO namesResponseDTO = new ProjectNamesResponseDTO();
            namesResponseDTO.setProjectId(project.getProjectId());
            namesResponseDTO.setProjectName(project.getProjectName());
            return namesResponseDTO;
        })).toList();
    }

    public ProjectResponseDTO updateProject(ProjectDTO projectDTO, int id){
        Project updateProject = projectRepository.findById(id).orElseThrow();
        updateProject.setProjectName(projectDTO.getProjectName());
        updateProject.setProjectDescription(projectDTO.getProjectDescription());
        updateProject.setBoardList(updateProject.getBoardList());
        updateProject.setEpicList(updateProject.getEpicList());
        List<User> userList = new ArrayList<>();
        List<Integer> userDTOList = projectDTO.getUserList();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user1 = userRepository.findByUserName(username).orElseThrow();
        userList.add(user1);
        for (int i=0; i<projectDTO.getUserList().size(); i++){
            User user = userService.getUser(userDTOList.get(i));
            if (user != null){
                userList.add(user);
            }
        }
        updateProject.setUserList(userList);
        projectRepository.save(updateProject);



        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setProjectId(updateProject.getProjectId());
        projectResponseDTO.setProjectName(updateProject.getProjectName());
        projectResponseDTO.setProjectDescription(updateProject.getProjectDescription());

        List<ProjectBoardsResponseDTO> boardList1 =  updateProject.getBoardList().stream().map((board)->{
            ProjectBoardsResponseDTO projectBoardsResponseDTO = new ProjectBoardsResponseDTO();
            projectBoardsResponseDTO.setBoardId(board.getBoardId());
            projectBoardsResponseDTO.setBoardName(board.getBoardName());
            List<ProjectBoardSprintsResponseDTO> sprintList =  board.getSprintList().stream().map((sprint)->{
                ProjectBoardSprintsResponseDTO projectBoardSprintsResponseDTO = new ProjectBoardSprintsResponseDTO();
                projectBoardSprintsResponseDTO.setSprintId(sprint.getSprintId());
                projectBoardSprintsResponseDTO.setSprintName(sprint.getSprintName());
                return projectBoardSprintsResponseDTO;
            }).toList();
            projectBoardsResponseDTO.setSprintList(sprintList);
            return projectBoardsResponseDTO;
        }).toList();
        projectResponseDTO.setBoardList(boardList1);

        List<ProjectEpicsResponseDTO> epicList1 = updateProject.getEpicList().stream().map((epic)->{
            ProjectEpicsResponseDTO projectEpicsResponseDTO = new ProjectEpicsResponseDTO();
            projectEpicsResponseDTO.setEpicId(epic.getEpicId());
            projectEpicsResponseDTO.setEpicName(epic.getEpicName());
            return projectEpicsResponseDTO;
        }).toList();
        projectResponseDTO.setEpicList(epicList1);

        List<ProjectUsersResponseDTO> userList1 = updateProject.getUserList().stream().map((user)->{
            ProjectUsersResponseDTO projectUsersResponseDTO = new ProjectUsersResponseDTO();
            projectUsersResponseDTO.setUserId(user.getUserId());
            projectUsersResponseDTO.setUserName(user.getUserName());
            return projectUsersResponseDTO;
        }).toList();
        projectResponseDTO.setUserList(userList1);

        return projectResponseDTO;
    }

    public void deleteProject(int id){
        projectRepository.deleteById(id);
    }

}
