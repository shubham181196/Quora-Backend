package com.example.quoraApp.Service;


import com.example.CentralRepository.models.Follow;
import com.example.CentralRepository.models.Users;
import com.example.quoraApp.Repository.FollowRepo;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class followServiceImpl implements followService {
    private final FollowRepo followRepo;
    private final UserRepo userRepo;
    @Autowired
    public followServiceImpl(FollowRepo followRepo,UserRepo userRepo){
        this.followRepo=followRepo;
        this.userRepo=userRepo;
    }


    @Override
    public String saveFollow(UUID userId, UUID targetId) {
        Optional<Users> user1=userRepo.findById(userId);
        Optional<Users> user2=userRepo.findById(targetId);
        if(user1.isPresent() && user2.isPresent()){
            Follow follow=new Follow();
            follow.setTo(user1.get());
            follow.setFrom(user2.get());
            followRepo.save(follow);
            return "you are following user "+user2.get().getUserName();
        }
        return null;
    }
}
