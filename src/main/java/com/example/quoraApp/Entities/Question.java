package com.example.quoraApp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="question")
public class Question extends Base  {
    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "body",nullable = false)
    private String body;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="question_user")
    @JsonBackReference
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_topic",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    @JsonManagedReference
    private Set<Topic> topics;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private Set<Answer> answers;

}
