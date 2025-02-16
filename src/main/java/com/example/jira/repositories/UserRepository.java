package com.example.jira.repositories;

import com.example.jira.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   Optional< User> findByUserName(String username);


   @Query("SELECT DISTINCT u FROM User u " +
           "JOIN u.projectList p " +
           "JOIN p.boardList b " +
           "JOIN b.sprintList s " +
           "WHERE s.sprintId = :sprintId")
   List<User> findDistinctUsersBySprintId(@Param("sprintId") Integer sprintId);
}
