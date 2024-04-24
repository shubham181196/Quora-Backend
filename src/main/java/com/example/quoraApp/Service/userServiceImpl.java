package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.UserUpdateDTO;
import com.example.quoraApp.Entities.User;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class userServiceImpl implements userService {

    private UserRepo userRepository;
    @Autowired
    public userServiceImpl(UserRepo userRepository){
        this.userRepository=userRepository;
    }

    public Optional<User> getUserById(UUID id) {
        Optional<User>user= userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, UUID id) {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UserUpdateDTO userDTO,UUID userId) {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            User user1=user.get();
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

}
