package com.example.quoraApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends Base {

    @Column(name = "text")
    private String text;

    @Column(name = "parent_id",nullable = false)
    private UUID parentId;

    @Column(name = "user_id",nullable = false)
    private UUID userId;

    // Constructors, getters, setters...
}
