package com.acones.quiz_app.service;

import com.acones.quiz_app.dao.QuestionDao;
import com.acones.quiz_app.dao.QuizDao;
import com.acones.quiz_app.model.Question;
import com.acones.quiz_app.model.QuestionWraper;
import com.acones.quiz_app.model.Quiz;
import com.acones.quiz_app.model.Response;
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
    private QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWraper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsDB = quiz.get().getQuestions();
        List<QuestionWraper> questionsUser = new ArrayList<>();

        for (Question q : questionsDB) {
            QuestionWraper qw = new QuestionWraper(q.getId(), q.getCategory(), q.getQuestionTitle(), q.getDifficultyLevel(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());

            questionsUser.add(qw);
        }

        return new ResponseEntity<>(questionsUser, HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResponse(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();

        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
