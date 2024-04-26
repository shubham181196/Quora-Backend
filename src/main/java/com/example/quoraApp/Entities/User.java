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

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User extends Base{

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String emailId;

    @Column
    private String bio;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Question> question;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Answer> answers;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Like> likes;

    @OneToMany(mappedBy="to",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Follow> followers;

    @OneToMany(mappedBy="from",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Follow> following;

    @OneToMany(mappedBy = "comment_user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

}
