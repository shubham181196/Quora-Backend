package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TopicRepo extends JpaRepository<Topic, UUID> {
    Topic findByName(String topicName);
}
