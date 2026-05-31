package com.quizService.quiz.Service.Dao;


import com.quizService.quiz.Service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,  Integer> {
}
