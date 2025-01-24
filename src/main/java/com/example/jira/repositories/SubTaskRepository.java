package com.example.jira.repositories;

import com.example.jira.models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {
}
