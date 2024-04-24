package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, UUID> {
    List<Answer> findByUserId(UUID userId);

}
