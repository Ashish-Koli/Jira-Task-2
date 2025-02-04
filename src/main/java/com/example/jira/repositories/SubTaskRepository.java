package com.example.jira.repositories;

import com.example.jira.models.Comment;
import com.example.jira.models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {

    List<SubTask> findByStory_StoryId(int id);
}
