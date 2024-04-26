package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.UserUpdateDTO;
import com.example.quoraApp.Entities.Follow;
import com.example.quoraApp.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface userService {
    public Optional<User> getUserById(UUID id);
    public User saveUser(UserUpdateDTO user);
    public User updateUser(User user, UUID id);

    public List<User> getAllUser();
    public User updateUser(UserUpdateDTO userDTO,UUID userId);
    public List<User> getAllFollowers(UUID userId);
    public String deleteUserById(UUID id);

}
