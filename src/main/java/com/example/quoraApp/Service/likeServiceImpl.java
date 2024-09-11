package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Like;
import com.example.CentralRepository.models.LikedEntityType;
import com.example.CentralRepository.models.Users;
import com.example.quoraApp.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class likeServiceImpl implements likeService {
    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final AnswerRepo answerRepo;
    private final QuestionRepo questionRepo;
    private final CommentRepo commentRepo;
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
        Optional<Users> user=userRepo.findById(userId);
        Optional<?>type1 = Optional.empty();
        if(like==LikedEntityType.answers){
            type1=answerRepo.findById(id);
        }else if(like==LikedEntityType.questions){
            type1=questionRepo.findById(id);
        }else if(like==LikedEntityType.comments){
            type1=commentRepo.findById(id);
        }

        assert Objects.requireNonNull(type1).isPresent();
        if(user.isPresent()){
            Like like1= new Like();
            like1.setLikedEntityId(id);
            like1.setLikedEntityType(like);
            like1.setUser(user.get());
            likeRepo.save(like1);
            return "Like saved succesfully";
        }
        return null;

    }

    @Override
    public String deleteLike(LikedEntityType liketype, UUID id, UUID userId) {
        Optional<Users> user=userRepo.findById(userId);
        Optional<Like> userlike= Optional.empty();
        if(user.isPresent()) userlike=likeRepo.findLike(user.get(),liketype,id);
        assert Objects.requireNonNull(userlike).isPresent();
        userlike.ifPresent(likeRepo::delete);
        return "like deleted successfully";
    }

    @Override
    public Optional<Like> findLike(Users user, LikedEntityType like, UUID id) {
        return likeRepo.findLike(user,like,id);
    }
}
