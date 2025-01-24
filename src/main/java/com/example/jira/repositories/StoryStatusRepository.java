package com.example.jira.repositories;

import com.example.jira.models.StoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryStatusRepository extends JpaRepository<StoryStatus, Integer> {
}
