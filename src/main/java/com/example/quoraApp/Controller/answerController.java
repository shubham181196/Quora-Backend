package com.example.quoraApp.Controller;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.Answer;
import com.example.quoraApp.ErrorHandlers.ErrorHandler;
import com.example.quoraApp.Service.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class answerController {

    private answerService answerservice;
    @Autowired
    public answerController(answerService answerservice){
        this.answerservice=answerservice;
    }

    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<?> saveAnswer(@RequestBody RequestDTO requestbody, @PathVariable UUID questionId){

        if(requestbody.getUserId()==null && requestbody.getText()==null){
            return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad request.userId and text missing"));
        }else if(requestbody.getText()==null){
            return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad request.text missing"));
        }else if(requestbody.getUserId()==null ){
            return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad request.userId and text missing"));
        }
        Answer answer=answerservice.saveAnswer(requestbody,questionId);

        if(answer!=null) {
            return ResponseEntity.ok(answer);
        }
        return ResponseEntity.status(400).body(new ErrorHandler(400,"Incorrect questionId"));
    }
    @PutMapping("/answers/{answerId}")
    public ResponseEntity<?> updateAnswer(@RequestBody RequestDTO requestDTO, @PathVariable UUID answerId){
        if(requestDTO.getText()!=null){
            return ResponseEntity.ok(answerservice.updateAnswer(requestDTO.getText(),answerId));
        }
        return ResponseEntity.status(400).body(new ErrorHandler(400,"Bad request"));
    }
    @GetMapping("/answers/{userId}")
    public ResponseEntity<?> getAllAnswers(@PathVariable UUID userId){
        return ResponseEntity.ok(answerservice.getAllAnswer(userId));
    }

    @DeleteMapping("/answers/{answerId}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable UUID answerId){
        return ResponseEntity.ok(answerservice.deleteAnswer(answerId));
    }


}
