package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRopository extends JpaRepository<Comment, Integer> {
}
