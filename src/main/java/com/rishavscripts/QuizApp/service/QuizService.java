package com.rishavscripts.QuizApp.service;

import com.rishavscripts.QuizApp.models.Question;
import com.rishavscripts.QuizApp.models.QuestionWrapper;
import com.rishavscripts.QuizApp.models.Quiz;
import com.rishavscripts.QuizApp.models.Response;
import com.rishavscripts.QuizApp.repository.QuestionRepo;
import com.rishavscripts.QuizApp.repository.QuizRepo;
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
    private QuizRepo quizRepo;

    @Autowired
    private Question question;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Quiz Created Successfully",HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getDifficulty_level(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestiontitle(),q.getCategory());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int score=0,i=0;
        for(Response response: responses){
            if (response.getUserAnswer().equals(questions.get(i).getRightanswer()))
                score++;
            i++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
