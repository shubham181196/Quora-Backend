package com.example.quoraApp.Repository;

import com.example.CentralRepository.models.Answer;
import com.example.quoraApp.DTOS.AnswerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, UUID> {
    List<Answer> findByUserId(UUID userId);
    @Query("SELECT new com.example.quoraApp.DTOS.AnswerDTO(a.id, a.user.id,a.user.userName, a.text) from Answer a where a.question.id=:questionId")
    List<AnswerDTO>getAnswersByQuestionId(UUID questionId);
}
