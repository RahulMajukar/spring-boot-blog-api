package com.hackifytech.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hackifytech.blog.models.CategoryTag;
import com.hackifytech.blog.services.CategoryTagService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-tags")
public class CategoryTagController {

	@Autowired
    private CategoryTagService categoryTagService;


    @GetMapping
    public ResponseEntity<List<CategoryTag>> getAllCategoryTags() {
        List<CategoryTag> categoryTags = categoryTagService.getAllCategoryTags();
        return new ResponseEntity<>(categoryTags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryTag> getCategoryTagById(@PathVariable Long id) {
        Optional<CategoryTag> categoryTag = categoryTagService.getCategoryTagById(id);
        return categoryTag.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CategoryTag> createCategoryTag(@RequestBody CategoryTag categoryTag) {
        CategoryTag createdCategoryTag = categoryTagService.createCategoryTag(categoryTag);
        return new ResponseEntity<>(createdCategoryTag, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryTag(@PathVariable Long id) {
        categoryTagService.deleteCategoryTag(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

