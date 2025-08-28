package com.rishavscripts.QuizApp.repository;

import com.rishavscripts.QuizApp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {


}
