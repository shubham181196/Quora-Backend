package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Users;
import com.example.quoraApp.DTOS.UserUpdateDTO;
import com.example.quoraApp.Repository.FollowRepo;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class userServiceImpl implements userService {

    private UserRepo userRepository;
    private FollowRepo followRepo;
    @Autowired
    public userServiceImpl(UserRepo userRepository,FollowRepo followRepo){
        this.userRepository=userRepository;
        this.followRepo=followRepo;
    }

    public Optional<Users> getUserById(UUID id) {
        Optional<Users>user= userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }
        return null;
    }

    @Override
    public Users saveUser(UserUpdateDTO user) {
        Users user1=new Users();
        user1.setUserName(user.getUserName());
        user1.setEmailId(user.getEmailId());
        if(user.getBio()!=null) user1.setBio(user.getBio());
        return userRepository.save(user1);
    }

    @Override
    public Users updateUser(Users user, UUID id) {
        Optional<Users> user1 = userRepository.findById(id);
        if (user1.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(UserUpdateDTO userDTO,UUID userId) {
        Optional<Users> user=userRepository.findById(userId);
        if(user.isPresent()){
            Users user1=user.get();
            System.out.println(user1);
            if(userDTO.getUserName()!=null){
                user1.setUserName(userDTO.getUserName());
            }
            if(userDTO.getEmailId()!=null){
                user1.setEmailId(userDTO.getEmailId());
            }
            if (userDTO.getBio()!=null){
                user1.setBio(userDTO.getBio());
            }
            return userRepository.save(user1);
        }
        return null;
    }

    @Override
    public List<Users> getAllFollowers(UUID userId) {
        return null;
//        List<UUID>follows= followRepo.findByFollowerId(userId);
//        List<User> users = userRepository.findUsersByUserIds(follows);
////
////        System.out.println(user.get(0));
//        return users;
    }

    @Override
    public String deleteUserById(UUID id) {
        Optional<Users>user=userRepository.findById(id);
       if(user.isPresent()){
           userRepository.deleteById(id);
           return "user deleted successfully";
       }
       return "bad credentials";

    }


}
