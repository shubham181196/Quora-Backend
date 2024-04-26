package com.example.quoraApp.Service;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.Answer;
import com.example.quoraApp.Entities.Question;
import com.example.quoraApp.Entities.User;
import com.example.quoraApp.Repository.AnswerRepo;
import com.example.quoraApp.Repository.QuestionRepo;
import com.example.quoraApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class answerServiceImpl implements answerService{
    private AnswerRepo answerRepo;
    private final QuestionRepo questionRepo;
    private final UserRepo userRepo;
    @Autowired
    public answerServiceImpl(AnswerRepo answerRepo,QuestionRepo questionRepo,UserRepo userRepo){
        this.answerRepo=answerRepo;
        this.questionRepo=questionRepo;
        this.userRepo=userRepo;
    }
    @Override
    public Answer saveAnswer(RequestDTO requestDTO, UUID questionId) {
        // Find the question by its ID
        Optional<Question> questionOptional = questionRepo.findById(questionId);
        if (questionOptional.isEmpty()) {
            // Handle the case when the question is not found
            throw new RuntimeException("Question not found with ID: " + questionId);
        }

        // Find the user by their ID
        Optional<User> userOptional = userRepo.findById(requestDTO.getUserId());
        if (userOptional.isEmpty()) {
            // Handle the case when the user is not found
            throw new RuntimeException("User not found with ID: " + requestDTO.getUserId());
        }

        // Create a new answer
        Answer answer = new Answer();
        answer.setQuestion(questionOptional.get());
        answer.setText(requestDTO.getText());
        answer.setUser(userOptional.get());
        System.out.println(answer);

        // Save the answer
        try {
            return answerRepo.save(answer);
        } catch (Exception e) {
            // Handle any errors that occur during the save operation
            throw new RuntimeException();
        }
    }

    @Override
    public Answer updateAnswer(String text, UUID answerId) {
        Optional<Answer> answer=answerRepo.findById(answerId);
        if(answer.isPresent()){
            Answer answer1=answer.get();
            answer1.setText(text);
            return answerRepo.save(answer1);
        }
        return null;
    }

    @Override
    public List<Answer> getAllAnswer(UUID userId) {
        return answerRepo.findByUserId(userId);

    }

    @Override
    public String deleteAnswer(UUID answerId) {
        Optional<Answer> answer=answerRepo.findById(answerId);
        if(answer.isPresent()){
            answerRepo.deleteById(answerId);
            return  "answer deleted succesfullly";

        }
        return "incorrect asnwer id";
    }

}
