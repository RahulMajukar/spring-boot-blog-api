package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackifytech.blog.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
