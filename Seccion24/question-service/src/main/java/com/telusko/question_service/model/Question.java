package com.telusko.question_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

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

    @NonNull
    @Column(name = "right_answer")
    private String rightAnswer;
}
