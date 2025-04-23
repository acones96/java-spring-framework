package com.telusko.quiz_service.feign;

import com.telusko.quiz_service.model.QuestionWraper;
import com.telusko.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Help us to connect our quiz service to the question service
 *
 * @implNote  is a declarative REST client that allow us to call another service's API instead of writing an HTTP client code, we only write a Java Interface and Spring handle the rest. We need to also name the service name in the {@code application.properties} and in the main class the {@code @EnableFeignClients}.
 */
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);

    @PostMapping("question/getQuestions")
    ResponseEntity<List<QuestionWraper>> getQuestionsFromId(@RequestBody List<Integer> questionsId);

    @PostMapping("question/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
