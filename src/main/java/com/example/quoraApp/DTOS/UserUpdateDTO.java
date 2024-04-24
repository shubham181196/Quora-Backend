package com.example.quoraApp.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateDTO {

    private String userName;
    private String emailId;
    private String Bio;
}
