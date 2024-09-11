package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Answer;
import com.example.quoraApp.DTOS.RequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface answerService {
    Answer saveAnswer(RequestDTO requestBody, UUID questionId);
    Answer updateAnswer(String text,UUID answerId);
    List<Answer> getAllAnswer(UUID userId);
    String deleteAnswer(UUID answerId);
}
