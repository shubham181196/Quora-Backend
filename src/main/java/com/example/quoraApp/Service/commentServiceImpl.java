package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.Answer;
import com.example.quoraApp.Entities.Comment;
import com.example.quoraApp.Entities.User;
import com.example.quoraApp.Repository.AnswerRepo;
import com.example.quoraApp.Repository.CommentRepo;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class commentServiceImpl implements commentService{
    private CommentRepo commentRepo;
    private AnswerRepo answerRepo;
    private UserRepo userRepo;
    @Autowired
    public commentServiceImpl(CommentRepo commentRepo,AnswerRepo answerRepo,UserRepo userRepo){
        this.commentRepo=commentRepo;
        this.answerRepo=answerRepo;
        this.userRepo=userRepo;
    }

    @Override
    public Comment saveCommentAnswer(UUID answerId, RequestDTO requestDTO) {
        Optional<Answer> answer1=answerRepo.findById(answerId);
        Optional<User> user1=userRepo.findById(requestDTO.getUserId());
        if((requestDTO.getText()!=null || requestDTO.getUserId()!=null )&&(answer1.isPresent())){

            Comment comment=new Comment(requestDTO.getText(),answerId,user1.get());
            return commentRepo.save(comment);
        }

        return null;
    }

    @Override
    public Comment saveComment(UUID commentId, RequestDTO requestDTO) {
        Optional<Comment> comment1=commentRepo.findById(commentId);
        Optional<User> user1=userRepo.findById(requestDTO.getUserId());
        if((requestDTO.getText()!=null || requestDTO.getUserId()!=null )&&(comment1.isPresent())){
            Comment comment=new Comment(requestDTO.getText(),commentId,user1.get());
            return commentRepo.save(comment);
        }

        return null;
    }

    @Override
    public List<Comment> getCommentsByAnswerId(UUID answerId) {
        Optional<Answer> answer=answerRepo.findById(answerId);
        if(answer.isPresent()){
            return commentRepo.findByParentId(answerId);
        }
        return null;
    }
}
