package com.example.QuizApp.dao;

import com.example.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :NUMQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category,@Param("NUMQ") int numQ);
}
