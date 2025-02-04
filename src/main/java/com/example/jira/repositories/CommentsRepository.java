package com.example.jira.repositories;

import com.example.jira.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByStory_StoryId(int id);
}
