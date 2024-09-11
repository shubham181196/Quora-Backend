package com.example.quoraApp.Controller;

import com.example.CentralRepository.models.Users;
import com.example.quoraApp.DTOS.UserUpdateDTO;
import com.example.quoraApp.ErrorHandlers.ErrorHandler;
import com.example.quoraApp.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class userController {

    private final userService userservice;

    public userController(userService userservice){
        this.userservice=userservice;
    }

    @GetMapping("/users/{userId}")
    public Optional<Users> getUser(@PathVariable UUID userId){
            return userservice.getUserById(userId);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable UUID userId){
        return userservice.deleteUserById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> saveUser(@RequestBody UserUpdateDTO userRequestBody){
        return ResponseEntity.status(201).body(userservice.saveUser(userRequestBody));
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>> saveUser(){
        return ResponseEntity.status(200).body(userservice.getAllUser());
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDTO userRequestBody, @PathVariable UUID userId){
        Users user1=userservice.updateUser(userRequestBody,userId);
        if(user1!=null){
            return ResponseEntity.ok(user1);
        }
        return ResponseEntity.status(404).body(new ErrorHandler(404,"User not found"));
    }
    @GetMapping("/users/{userId}/followers")
    public List<Users> getAllFollowers(@PathVariable UUID userId){
        return userservice.getAllFollowers(userId);
    }
}
