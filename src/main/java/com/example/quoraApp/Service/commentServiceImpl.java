package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.Answer;
import com.example.quoraApp.Entities.Comment;
import com.example.quoraApp.Repository.AnswerRepo;
import com.example.quoraApp.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class commentServiceImpl implements commentService{
    private CommentRepo commentRepo;
    private AnswerRepo answerRepo;
    @Autowired
    public commentServiceImpl(CommentRepo commentRepo,AnswerRepo answerRepo){
        this.commentRepo=commentRepo;
        this.answerRepo=answerRepo;
    }

    @Override
    public Comment saveCommentAnswer(UUID answerId, RequestDTO requestDTO) {
        Optional<Answer> answer1=answerRepo.findById(answerId);
        if((requestDTO.getText()!=null || requestDTO.getUserId()!=null )&&(answer1.isPresent())){
            System.out.println(answer1.get());
            Comment comment=new Comment(requestDTO.getText(),answerId,requestDTO.getUserId());
            return commentRepo.save(comment);
        }

        return null;
    }

    @Override
    public Comment saveComment(UUID commentId, RequestDTO requestDTO) {
        Optional<Comment> comment1=commentRepo.findById(commentId);
        if((requestDTO.getText()!=null || requestDTO.getUserId()!=null )&&(comment1.isPresent())){
            Comment comment=new Comment(requestDTO.getText(),commentId,requestDTO.getUserId());
            return commentRepo.save(comment);
        }

        return null;
    }
}
