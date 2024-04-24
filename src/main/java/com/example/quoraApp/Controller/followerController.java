package com.example.quoraApp.Controller;


import com.example.quoraApp.Entities.Follow;
import com.example.quoraApp.Service.followService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class followerController {
    private followService followservice;
    @Autowired
    public followerController(followService followservice){
        this.followservice=followservice;
    }
    @PostMapping("/users/{userId}/follow/{targetUserId}")
    public ResponseEntity<?> saveFollow(@PathVariable UUID userId , @PathVariable UUID targetUserId){
        String resp=followservice.saveFollow(userId,targetUserId);
        if(resp!=null) return ResponseEntity.status(201).body(resp);
        return ResponseEntity.status(400).body("Bad Request");
    }

}
