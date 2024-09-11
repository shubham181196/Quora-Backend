package com.example.quoraApp.Service;

import com.example.CentralRepository.models.Question;
import com.example.CentralRepository.models.Topic;
import com.example.CentralRepository.models.Users;
import com.example.quoraApp.DTOS.QuestionDTO;
import com.example.quoraApp.DTOS.QuestionListDTO;
import com.example.quoraApp.Repository.QuestionRepo;
import com.example.quoraApp.Repository.TopicRepo;
import com.example.quoraApp.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@Transactional
public class questionServiceImpl implements questionService{
    private QuestionRepo questionRepo;
    private TopicRepo topicRepo;
    private UserRepo userRepo;
    @Autowired
    public questionServiceImpl(QuestionRepo questionRepo,UserRepo userRepo,TopicRepo topicRepo){
        this.questionRepo=questionRepo;
        this.userRepo=userRepo;
        this.topicRepo=topicRepo;
    }

    @Override
    public Question saveQuestion(QuestionDTO questionDTO) {

        // We are already verifying this form auth service
        Optional<Users> user = userRepo.findById(questionDTO.getUserId());

        if (!user.isPresent()) return null;
        Set<Topic> topics = null;
        if (questionDTO.getTopics() != null) {
            topics = new HashSet<>();
            for (String topicName : questionDTO.getTopics()) {
                Topic topic = topicRepo.findByName(topicName);
                if (topic == null) {
                    System.out.println(topicName);
                    topic = new Topic(topicName);
                    topic = topicRepo.save(topic);
                }
                topics.add(topic);
            }

        }

        Question question = new Question();
        question.setUser(user.get());
        question.setTitle(questionDTO.getTitle());
        question.setBody(questionDTO.getBody());
        question.setTopics(topics);
        question = questionRepo.save(question);
        return question;

    }

    @Override
    public List<QuestionListDTO> findQuestions(UUID userId) {
        return questionRepo.findAllQuestionList(userId);
    }


    @Override
    public List<Question> findAllQuestionByUserId(UUID userId) {

        return questionRepo.findByUser(userId);
    }

    @Override
    public List<Question> findAllQuestionByTextAndTags(String text, List<String> tags) {
        return questionRepo.findByTopicsAndText(tags,text);
    }

    @Override
    public List<Question> findAllQuestionByTags(List<String> tags) {
        return questionRepo.findByTopics(tags);
    }

    @Override
    public List<Question> findAllQuestionByText(String text) {
        return questionRepo.findByText(text);
    }

    @Override
    public List<Question> findAll() {
        return questionRepo.findAll();
    }


}
