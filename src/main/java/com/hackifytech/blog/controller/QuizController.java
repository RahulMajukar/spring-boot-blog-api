package com.hackifytech.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackifytech.blog.models.Question;
import com.hackifytech.blog.models.Quiz;
import com.hackifytech.blog.services.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;

	@GetMapping("/questions")
	public List<Question> getQuestions() {
		return quizService.getAllQuestions();
	}

	@GetMapping("/quizzes")
	public List<Quiz> getQuizzes() {
		return quizService.getAllQuizzes();
	}
}
