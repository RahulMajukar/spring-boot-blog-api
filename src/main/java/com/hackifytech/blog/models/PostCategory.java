package com.hackifytech.blog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "post_categories")
public class PostCategory {   
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "category_tag_id", nullable = false)
    private CategoryTag categoryTag;

    // Getters and Setters
    // Constructor(s)
    // Additional methods
}
