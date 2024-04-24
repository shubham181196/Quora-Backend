package com.example.quoraApp.Service;

import com.example.quoraApp.Entities.Topic;
import com.example.quoraApp.Repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class topicServiceImpl implements topicService{
    private TopicRepo topicRepo;
    @Autowired
    public topicServiceImpl(TopicRepo topicRepo){
        this.topicRepo=topicRepo;
    }


    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepo.save(topic);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }
}
