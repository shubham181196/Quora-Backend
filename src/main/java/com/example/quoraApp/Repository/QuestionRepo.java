package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Question;
import com.example.quoraApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepo extends JpaRepository<Question, UUID> {

    List<Question> findByUser(User user);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE t.name IN :topicNames AND q.title LIKE %:text%")
    List<Question> findByTopicsAndText(@Param("topicNames") List<String> topicNames, @Param("text") String text);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE t.name IN :topicNames")
    List<Question> findByTopics(@Param("topicNames") List<String> topicNames);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE q.title LIKE %:text%")
    List<Question> findByText(@Param("text") String text);

}
