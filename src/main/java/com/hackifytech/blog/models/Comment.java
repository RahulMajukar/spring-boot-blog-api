package com.hackifytech.blog.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog post;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Date timestamp;

    @Column
    private int likesCount;

    @Column(nullable = false)
    private String status;

    // Getters and Setters
    // Constructor(s)
    // Additional methods
}

