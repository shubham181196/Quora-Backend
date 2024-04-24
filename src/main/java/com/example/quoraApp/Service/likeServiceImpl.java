package com.example.quoraApp.Service;

import com.example.quoraApp.Entities.*;
import com.example.quoraApp.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class likeServiceImpl implements likeService {
    private LikeRepo likeRepo;
    private UserRepo userRepo;
    private AnswerRepo answerRepo;
    private QuestionRepo questionRepo;
    private CommentRepo commentRepo;
    @Autowired
    public likeServiceImpl(LikeRepo likeRepo,UserRepo userRepo,AnswerRepo answerRepo,QuestionRepo questionRepo,CommentRepo commentRepo){
        this.likeRepo=likeRepo;
        this.userRepo=userRepo;
        this.answerRepo=answerRepo;
        this.questionRepo=questionRepo;
        this.commentRepo=commentRepo;
    }

    @Override
    public String saveLike(LikedEntityType like, UUID id, UUID userId) {
        Optional<User> user=userRepo.findById(userId);
        Optional<?>type1 = null;
        if(like==LikedEntityType.answers){
            type1=answerRepo.findById(id);
        }else if(like==LikedEntityType.questions){
            type1=questionRepo.findById(id);
        }else if(like==LikedEntityType.comments){
            type1=commentRepo.findById(id);
        }

        if(type1.isPresent() && user.isPresent()){
            Like like1= new Like();
            like1.setLikedEntityId(id);
            like1.setLikedEntityType(like);
            like1.setUser(user.get());
            Like savedLike =likeRepo.save(like1);
            if(savedLike!=null) return "like saved succesfully";

        }
        return null;

    }
}
