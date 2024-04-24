package com.example.quoraApp.Controller;

import com.example.quoraApp.Entities.Topic;
import com.example.quoraApp.Service.topicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class topicController {
    private topicService topicservice;
    @Autowired
    public topicController(topicService topicservice){
        this.topicservice=topicservice;
    }
    @PostMapping("/topics")
    public Topic savetopics(@RequestBody Topic topic){
        return topicservice.saveTopic(topic);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics(){
        return ResponseEntity.ok(topicservice.getAllTopics());
    }

}
