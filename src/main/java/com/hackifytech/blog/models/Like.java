package com.hackifytech.blog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    // Getters and Setters
    // Constructor(s)
    // Additional methods
}
