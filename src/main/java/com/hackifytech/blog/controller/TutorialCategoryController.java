package com.hackifytech.blog.controller;

import com.hackifytech.blog.models.TutorialCategory;
import com.hackifytech.blog.services.TutorialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorial-categories")
public class TutorialCategoryController {

    @Autowired
    private TutorialCategoryService tutorialCategoryService;

    @GetMapping
    public ResponseEntity<List<TutorialCategory>> getAllTutorialCategories() {
        List<TutorialCategory> categories = tutorialCategoryService.getAllTutorialCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialCategory> getTutorialCategoryById(@PathVariable Long id) {
        Optional<TutorialCategory> categoryOpt = tutorialCategoryService.getTutorialCategoryById(id);
        if (categoryOpt.isPresent()) {
            return ResponseEntity.ok(categoryOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TutorialCategory> createTutorialCategory(@RequestBody TutorialCategory category) {
        TutorialCategory createdCategory = tutorialCategoryService.createTutorialCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorialCategory> updateTutorialCategory(@PathVariable Long id, @RequestBody TutorialCategory category) {
        TutorialCategory updatedCategory = tutorialCategoryService.updateTutorialCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutorialCategory(@PathVariable Long id) {
        Optional<TutorialCategory> categoryOpt = tutorialCategoryService.getTutorialCategoryById(id);
        if (categoryOpt.isPresent()) {
            tutorialCategoryService.deleteTutorialCategory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
