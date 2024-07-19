package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackifytech.blog.models.TutorialCategory;

public interface TutorialCategoryRepository extends JpaRepository<TutorialCategory, Long> {
}
