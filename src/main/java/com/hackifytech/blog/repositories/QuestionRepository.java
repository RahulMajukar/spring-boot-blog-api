package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackifytech.blog.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
