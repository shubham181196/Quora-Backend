package com.example.quoraApp.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    private UUID userId;
    private String title;
    private String body;
    private List<String> Topics;
}
