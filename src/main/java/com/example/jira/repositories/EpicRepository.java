package com.example.jira.repositories;

import com.example.jira.models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface EpicRepository extends JpaRepository<Epic, Integer> {

    @Query("SELECT e FROM Epic e " +
            "LEFT JOIN e.project p " +
            "LEFT JOIN p.userList u " +
            "WHERE u.userId = :userId")
    List<Epic> findEpicsByUserId(@Param("userId") int userId);
}
