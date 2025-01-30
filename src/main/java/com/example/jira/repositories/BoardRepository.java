package com.example.jira.repositories;

import com.example.jira.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("SELECT b FROM Board b WHERE b.project.projectId = :projectId")
    List<Board> findBoardsByProjectId(@Param("projectId") int projectId);

    @Query("SELECT b FROM Board b JOIN b.project p JOIN p.userList u WHERE u.userId = :userId")
    List<Board> findBoardsByUserId(@Param("userId") int userId);
}
