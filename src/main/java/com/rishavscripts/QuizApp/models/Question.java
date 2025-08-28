package com.rishavscripts.QuizApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questiontitle;
    private String rightanswer;
    private String category;
}
