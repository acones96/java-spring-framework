package com.telusko.question_service.service;

import com.telusko.question_service.dao.QuestionDao;
import com.telusko.question_service.model.Question;
import com.telusko.question_service.model.QuestionWraper;
import com.telusko.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions () {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            List<Question> questions = questionDao.findByCategory(category);
            if (!questions.isEmpty()) {
                return new ResponseEntity<>(questions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("something happened", HttpStatus.CONFLICT);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWraper>> getQuestionsFromIds(List<Integer> questionsIds) {
        List<Question> questionList = new ArrayList<>();
        List<QuestionWraper> questionWraperList = new ArrayList<>();

        for (Integer id : questionsIds) {
            questionList.add(questionDao.findById(id).get());
        }

        for (Question question : questionList) {
            QuestionWraper questionWraper = getQuestionWraper(question);
            questionWraperList.add(questionWraper);
        }

        return new ResponseEntity<>(questionWraperList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> setScore(List<Response> responses) {
        int right = 0;
        for (Response response : responses) {

            Question question = questionDao.findById(response.getId()).get();

            if (response.getResponse().equals(question.getRightAnswer()))
                right++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }

    private static QuestionWraper getQuestionWraper(Question question) {
        QuestionWraper questionWraper = new QuestionWraper();

        questionWraper.setId(question.getId());
        questionWraper.setCategory(question.getCategory());
        questionWraper.setDifficultyLevel(question.getDifficultyLevel());
        questionWraper.setQuestionTitle(question.getQuestionTitle());
        questionWraper.setOption1(question.getOption1());
        questionWraper.setOption2(question.getOption2());
        questionWraper.setOption3(question.getOption3());
        questionWraper.setOption4(question.getOption4());

        return questionWraper;
    }
}
