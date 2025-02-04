package com.example.jira.repositories;

import com.example.jira.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

    @Query("SELECT p FROM Project p JOIN p.userList u WHERE u.userId = :userId")
    List<Project> findProjectsByUserId(@Param("userId") int userId);
}
