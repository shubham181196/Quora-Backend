package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.QuestionDTO;
import com.example.quoraApp.Entities.Question;
import com.example.quoraApp.Entities.Topic;
import com.example.quoraApp.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface questionService {
    public Question saveQuestion(QuestionDTO questionDTO);
    public List<Question> findAllQuestionByUserId(UUID userId);
    public List<Question>findAllQuestionByTextAndTags(String text,List<String> tags);
    public List<Question>findAllQuestionByTags(List<String> tags);
    public List<Question>findAllQuestionByText(String text);

    List<Question> findAll();
}
