package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Question;
import com.example.quoraApp.DTOS.QuestionDTO;
import com.example.quoraApp.DTOS.QuestionListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface questionService {
    public Question saveQuestion(QuestionDTO questionDTO);
    public List<QuestionListDTO> findQuestions(UUID userId);
    public List<Question> findAllQuestionByUserId(UUID userId);
    public List<Question>findAllQuestionByTextAndTags(String text,List<String> tags);
    public List<Question>findAllQuestionByTags(List<String> tags);
    public List<Question>findAllQuestionByText(String text);
    public List<Question>findAll();
}
