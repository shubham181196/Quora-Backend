package com.example.quoraApp.Controller;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.Comment;
import com.example.quoraApp.ErrorHandlers.ErrorHandler;
import com.example.quoraApp.Service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class commentController {
    private commentService commentservice;
    @Autowired
    public commentController(commentService commentservice){
        this.commentservice=commentservice;
    }
    @PostMapping("/answers/{answerId}/comments")
    public ResponseEntity<?> saveComment(@RequestBody RequestDTO requestDTO, @PathVariable UUID answerId){
        Comment comment= commentservice.saveCommentAnswer(answerId,requestDTO);
        if(comment!=null) return ResponseEntity.ok(comment);
        return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad Request"));
    }
    @PostMapping("/comments/{commentId}/comments")
    public ResponseEntity<?> saveCommentOnComment(@RequestBody RequestDTO requestDTO, @PathVariable UUID commentId){
        Comment comment=  commentservice.saveComment(commentId,requestDTO);
        if(comment!=null) return ResponseEntity.ok(comment);
        return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad Request"));
    }

    @GetMapping("/comments/{answerId}/answer")
    public ResponseEntity<List<?>> getAllCommentsOnAnswer(@PathVariable UUID answerId){
        List<Comment> comment=  commentservice.getCommentsByAnswerId(answerId);
        return ResponseEntity.ok(comment);
    }
}
