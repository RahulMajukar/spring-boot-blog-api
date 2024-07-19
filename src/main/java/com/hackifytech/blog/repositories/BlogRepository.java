package com.hackifytech.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hackifytech.blog.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Define custom methods if needed
	 Optional<Blog> findBySlug(String slug);
}