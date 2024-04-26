package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
    @Query("SELECT c FROM Comment c WHERE c.parentId = :parentId")
    List<Comment> findByParentId(@Param("parentId") UUID parentId);
}
