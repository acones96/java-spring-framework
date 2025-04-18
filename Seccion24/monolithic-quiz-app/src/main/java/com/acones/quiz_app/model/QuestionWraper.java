package com.acones.quiz_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class QuestionWraper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String category;

    @NonNull
    @Column(name = "difficultylevel")
    private String difficultyLevel;

    @NonNull
    @Column(name = "question_title")
    private String questionTitle;

    @NonNull
    private String option1;

    @NonNull
    private String option2;

    @NonNull
    private String option3;

    @NonNull
    private String option4;
}
