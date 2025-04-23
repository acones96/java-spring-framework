package com.telusko.quiz_service.service;

import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.feign.QuizInterface;
import com.telusko.quiz_service.model.QuestionWraper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuizInterface quizInterface;


    /**
     * @param category is the kind of the problem (python, java, etc.)
     * @param numQ are the number of questions in the quiz
     * @param title is the name of the quiz.
     *
     * @return will return a ResponseEntity with a {@code success} message and his status code.
     *
     * @implNote
     * <p>
     *     We can call the service by using RestTemplate and their http request (http://localhost:8080/question/generate).
     *</p>
     *
     * <p>
     *     Instead of that, we can use Feign and the QuizInterface which is adapted for all http request that Quiz will need.
     * </p>
     */
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    /**
     *
     * @param id quiz number identifier.
     * @return ResponseEntity list of QuestionWraper.
     * @implNote
     */
    public ResponseEntity<List<QuestionWraper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Integer> questionIds = quiz.get().getQuestions();
        ResponseEntity<List<QuestionWraper>> questions = quizInterface.getQuestionsFromId(questionIds);

        return questions;

    }

    /**
     *
     * @param id is the quiz identifier.
     * @param responses is the list of question id and client answers.
     * @return a {@code ResponseEntity<Integer>} which is the score of correct answers.
     */
    public ResponseEntity<Integer> calculateResponse(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
