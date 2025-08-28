package com.rishavscripts.QuizApp.models;

import jakarta.persistence.Id;
import lombok.Data;
import java.lang.Integer;

@Data
public class QuestionWrapper {
    @Id
    private Integer id;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questiontitle;
    private String category;

    public QuestionWrapper() {} // default constructor for JPA

    public QuestionWrapper(Integer id, String difficulty_level, String option1, String option2, String option3, String option4, String questiontitle, String category) {
        this.id = id;
        this.difficulty_level = difficulty_level;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.questiontitle = questiontitle;
        this.category = category;
    }
}
