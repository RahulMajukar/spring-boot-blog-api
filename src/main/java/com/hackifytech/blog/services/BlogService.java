package com.hackifytech.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackifytech.blog.models.Blog;
import com.hackifytech.blog.repositories.BlogRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public Blog getBlogById(Long id) {
		return blogRepository.findById(id).orElse(null);
	}

	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	public Optional<Blog> findBySlug(String slug) {
		return blogRepository.findBySlug(slug);
	}

	public Blog saveBlog(Blog post) {
		return blogRepository.save(post);
	}

	public void deleteBlog(Long id) {
		blogRepository.deleteById(id);
	}
}