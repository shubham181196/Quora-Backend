package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Users;
import com.example.quoraApp.DTOS.UserUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface userService {
    public Optional<Users> getUserById(UUID id);
    public Users saveUser(UserUpdateDTO user);
    public Users updateUser(Users user, UUID id);

    public List<Users> getAllUser();
    public Users updateUser(UserUpdateDTO userDTO,UUID userId);
    public List<Users> getAllFollowers(UUID userId);
    public String deleteUserById(UUID id);

}
