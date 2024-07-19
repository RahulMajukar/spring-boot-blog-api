package com.hackifytech.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackifytech.blog.models.Blog;
import com.hackifytech.blog.services.BlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
    	Blog post = blogService.getBlogById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> posts = blogService.getAllBlogs();
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog post) {
        Blog newPost = blogService.saveBlog(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
    	blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{slug}")
    public ResponseEntity<Optional<Blog>> getBlogBySlug(@PathVariable String slug) {
      Optional<Blog> blog = blogService.findBySlug(slug);
      if (blog.isPresent()) {
        return ResponseEntity.ok(blog);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
