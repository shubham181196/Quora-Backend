package com.example.quoraApp.Controller;

import com.example.quoraApp.DTOS.QuestionDTO;
import com.example.quoraApp.Entities.Question;
import com.example.quoraApp.ErrorHandlers.ErrorHandler;
import com.example.quoraApp.Service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class questionController {
    private questionService questionservice;
    @Autowired
    public questionController(questionService questionservice){
        this.questionservice=questionservice;
    }

    @PostMapping("/questions")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionDTO questionDTO){

        if(questionDTO.getBody()!=null && questionDTO.getUserId()!=null && questionDTO.getBody()!=null){
            Question savedQuestion=questionservice.saveQuestion(questionDTO);
            return ResponseEntity.status(201).body(savedQuestion);
        }
        return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad Request"));
    }
    @GetMapping("/questions/{userId}")
    public List<Question> findByUserId(@PathVariable UUID userId){
        return questionservice.findAllQuestionByUserId(userId);

    }
    @GetMapping("/questions/search")
    public List<Question> findQuestionByTagAndTest(@RequestParam(required = false) String text, @RequestParam(required = false) List<String>tags){
        if(text!=null && tags!=null){
            return questionservice.findAllQuestionByTextAndTags(text,tags);
        }else if(text!=null) {
            return questionservice.findAllQuestionByText(text);
        }else if(tags!=null){
            return questionservice.findAllQuestionByTags(tags);
        }else{
            return questionservice.findAll();
        }
    }

}
