package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackifytech.blog.models.Tutorial;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
	List<Tutorial> findBySideParent(String sideParent);
    List<Tutorial> findByIsPublished(boolean isPublished);
    
    @Query("SELECT t FROM Tutorial t WHERE t.category.categoryTitle = :categoryTitle")
    List<Tutorial> findByCategoryTitle(@Param("categoryTitle") String categoryTitle);
}