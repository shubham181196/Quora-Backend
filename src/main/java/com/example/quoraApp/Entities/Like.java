package com.example.quoraApp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "usersLike")
public class Like extends Base{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "liked_entity_id",nullable = false)
    private UUID likedEntityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "liked_entity_type",nullable = false)
    private LikedEntityType likedEntityType;
}
