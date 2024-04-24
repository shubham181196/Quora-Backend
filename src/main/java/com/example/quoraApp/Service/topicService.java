package com.example.quoraApp.Service;

import com.example.quoraApp.Entities.Topic;

import java.util.List;

public interface topicService {
    public Topic saveTopic(Topic topic);
    public List<Topic> getAllTopics();
}
