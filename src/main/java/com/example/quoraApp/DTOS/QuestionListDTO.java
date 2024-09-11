package com.example.quoraApp.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class QuestionListDTO {
    private UUID id;
    private String title;
    private String body;
    private long count;
    private Boolean userLiked;
}
