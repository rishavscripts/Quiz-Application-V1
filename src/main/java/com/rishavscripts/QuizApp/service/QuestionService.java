package com.rishavscripts.QuizApp.service;

import com.rishavscripts.QuizApp.models.Question;
import com.rishavscripts.QuizApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {

        try{
           return ResponseEntity.status(HttpStatus.OK).body(questionRepo.findByCategory(category));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return  new ResponseEntity<>("Question Posted Successfully.",HttpStatus.CREATED) ;
    }
}
