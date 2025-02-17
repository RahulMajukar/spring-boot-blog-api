package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackifytech.blog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define custom methods if needed
}