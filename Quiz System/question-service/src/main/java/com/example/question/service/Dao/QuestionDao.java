package com.example.question.service.Dao;

import com.example.question.service.model.Question;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Table(name = "questions")
@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


  List<Question> findByCategory(String category);
    @Query(
            value = "SELECT q.id FROM questions q  WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",
            nativeQuery = true
    )
//@Query(value = "select * from question q where q.category=:category order by random() limit : numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
