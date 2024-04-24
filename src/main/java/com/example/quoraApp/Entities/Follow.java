package com.example.quoraApp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "follow")
public class Follow extends Base {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    @JsonBackReference
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id")
    @JsonBackReference
    private User followee;
}
