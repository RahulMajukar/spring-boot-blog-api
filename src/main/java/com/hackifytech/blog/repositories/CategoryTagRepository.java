package com.hackifytech.blog.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackifytech.blog.models.CategoryTag;

@Repository
public interface CategoryTagRepository extends JpaRepository<CategoryTag, Long> {
   
}