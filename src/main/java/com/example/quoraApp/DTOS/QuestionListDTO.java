package com.example.quoraApp.DTOS;

import com.example.CentralRepository.models.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class QuestionListDTO {
    private UUID id;
    private String title;
    private String body;
    private long count;
    private Boolean userLiked;
    private List<AnswerDTO> answers=null;

    public QuestionListDTO(UUID id,String title,String body,long count,Boolean userLiked){
        this.id=id;
        this.title=title;
        this.body=body;
        this.count=count;
        this.userLiked=userLiked;
    }
}
