package com.example.quoraApp.Repository;


import com.example.CentralRepository.models.Question;
import com.example.CentralRepository.models.Users;
import com.example.quoraApp.DTOS.QuestionListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepo extends JpaRepository<Question, UUID> {
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.topics t LEFT JOIN FETCH q.answers a WHERE q.user.id = :userId")
    List<Question> findByUser(@Param("userId") UUID userId);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE t.name IN :topicNames AND q.title LIKE %:text%")
    List<Question> findByTopicsAndText(@Param("topicNames") List<String> topicNames, @Param("text") String text);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE t.name IN :topicNames")
    List<Question> findByTopics(@Param("topicNames") List<String> topicNames);
    @Query("SELECT q FROM Question q INNER JOIN q.topics t WHERE q.title LIKE %:text%")
    List<Question> findByText(@Param("text") String text);
//    @Query("SELECT new com.example.quoraApp.DTOS.QuestionListDTO(q.id ,q.title, q.body, COUNT(l)) FROM Question q LEFT JOIN  Like l ON l.likedEntityId = q.id AND l.likedEntityType = 'questions' GROUP BY q.id")
//    List<QuestionListDTO> findAllQuestionList();
    @Query("SELECT new com.example.quoraApp.DTOS.QuestionListDTO(q.id, q.title, q.body, COUNT(l), " +
            "CASE WHEN MAX(CASE WHEN l.user.id = :userId THEN 1 ELSE 0 END) = 1 THEN true ELSE false END) " +
            "FROM Question q " +
            "LEFT JOIN Like l ON l.likedEntityId = q.id AND l.likedEntityType = com.example.CentralRepository.models.LikedEntityType.questions " +
            "GROUP BY q.id")
    List<QuestionListDTO> findAllQuestionList(@Param("userId") UUID userId);

    List<Question> findAll();

}
