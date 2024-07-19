package com.hackifytech.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackifytech.blog.models.Question;
import com.hackifytech.blog.models.Quiz;
import com.hackifytech.blog.repositories.QuestionRepository;
import com.hackifytech.blog.repositories.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
