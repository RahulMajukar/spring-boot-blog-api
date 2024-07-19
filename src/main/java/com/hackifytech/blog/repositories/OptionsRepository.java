package com.hackifytech.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackifytech.blog.models.Options;

public interface OptionsRepository extends JpaRepository<Options, Long> {
}
