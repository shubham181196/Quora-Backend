package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Topic;


import java.util.List;

public interface topicService {
    public Topic saveTopic(Topic topic);
    public List<Topic> getAllTopics();
}
