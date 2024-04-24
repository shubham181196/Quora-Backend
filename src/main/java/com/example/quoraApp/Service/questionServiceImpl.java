package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.QuestionDTO;
import com.example.quoraApp.Entities.Question;
import com.example.quoraApp.Entities.Topic;
import com.example.quoraApp.Entities.User;
import com.example.quoraApp.Repository.QuestionRepo;
import com.example.quoraApp.Repository.TopicRepo;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

        Optional<User> user = userRepo.findById(questionDTO.getUserId());
        if (!user.isPresent()) return null;
        Set<Topic> topics = null;
        if (questionDTO.getTopics() != null) {
            topics = new HashSet<>();
            for (String topicName : questionDTO.getTopics()) {
                Topic topic = topicRepo.findByName(topicName);
                if (topic == null) {
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
    public List<Question> findAllQuestionByUserId(UUID userId) {
        Optional<User> user=userRepo.findById(userId);
        return user.map(value -> questionRepo.findByUser(value)).orElse(null);
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
