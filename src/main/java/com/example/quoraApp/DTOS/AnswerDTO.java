package com.example.quoraApp.DTOS;

import com.example.CentralRepository.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AnswerDTO {
    private UUID id;
    private UUID userId;
    private String username;
    private String text;
}
