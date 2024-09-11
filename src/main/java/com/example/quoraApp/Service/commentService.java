package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Comment;
import com.example.quoraApp.DTOS.RequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface commentService {
    Comment saveCommentAnswer(UUID answerId, RequestDTO requestDTO);

    Comment saveComment(UUID commentId, RequestDTO requestDTO);

    List<Comment> getCommentsByAnswerId(UUID answerId);
}
