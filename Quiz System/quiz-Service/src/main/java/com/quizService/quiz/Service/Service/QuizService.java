package com.quizService.quiz.Service.Service;
//
//import monolithicQuizApp.QuizApp.Dao.QuestionDao;
//import monolithicQuizApp.QuizApp.Dao.QuizDao;
//import monolithicQuizApp.QuizApp.model.Question;
//import monolithicQuizApp.QuizApp.model.QuestionWrapper;
//import monolithicQuizApp.QuizApp.model.Quiz;
//import monolithicQuizApp.QuizApp.model.Response;
import com.quizService.quiz.Service.Dao.QuizDao;
import com.quizService.quiz.Service.feign.QuizInterface;
import com.quizService.quiz.Service.model.Question;
import com.quizService.quiz.Service.model.QuestionWrapper;
import com.quizService.quiz.Service.model.Quiz;
import com.quizService.quiz.Service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    //@Autowired
//    Response response;
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> question = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(question);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
      List<Integer> questionIds =quiz.getQuestionIds();

      ResponseEntity<List<QuestionWrapper>>  questions = quizInterface.getQuestionsFromId(questionIds);

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
       ResponseEntity<Integer> score = quizInterface.getScore(responses);

return score;
//
    }
}
//}
