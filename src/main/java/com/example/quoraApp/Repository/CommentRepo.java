package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
}
