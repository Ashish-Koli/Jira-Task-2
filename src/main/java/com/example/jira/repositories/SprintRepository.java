package com.example.jira.repositories;

import com.example.jira.models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint,Integer> {

    @Query("SELECT s FROM Sprint s WHERE s.board.boardId = :boardId")
    List<Sprint> findSprintsByBoardId(@Param("boardId") int boardId);

    @Query("SELECT s FROM Sprint s " +
            "LEFT JOIN s.board b " +
            "LEFT JOIN b.project p " +
            "LEFT JOIN p.userList u " +
            "WHERE u.userId = :userId")
    List<Sprint> findSprintsByUserId(@Param("userId") int userId);
}
