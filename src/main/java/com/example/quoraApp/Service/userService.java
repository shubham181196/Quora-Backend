package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.UserUpdateDTO;
import com.example.quoraApp.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface userService {
    public Optional<User> getUserById(UUID id);
    public User saveUser(User user);
    public User updateUser(User user, UUID id);

    public List<User> getAllUser();
    public User updateUser(UserUpdateDTO userDTO,UUID userId);
}
