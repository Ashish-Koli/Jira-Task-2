package com.example.jira.repositories;

import com.example.jira.models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EpicRepository extends JpaRepository<Epic, Integer> {
}
