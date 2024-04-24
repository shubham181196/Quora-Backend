package com.example.quoraApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor

public class Base {
    public Base(){
        this.createdAt=new Date();
        this.updatedAt=new Date();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Temporal(TemporalType.DATE)
    protected Date createdAt;

    @Temporal(TemporalType.DATE)
    protected Date updatedAt;


}
