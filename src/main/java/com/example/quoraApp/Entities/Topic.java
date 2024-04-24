package com.example.quoraApp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="topic")
public class Topic extends Base{
    @Column(name="topic_name")
    private String name;

    @ManyToMany(mappedBy ="topics")
    @JsonBackReference
    private Set<Question> questions;

    public Topic(String topicName) {
        this.name=topicName;
    }
}
