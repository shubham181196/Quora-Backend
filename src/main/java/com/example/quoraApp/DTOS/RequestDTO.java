package com.example.quoraApp.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RequestDTO {
    private UUID userId;
    private String text;

}
