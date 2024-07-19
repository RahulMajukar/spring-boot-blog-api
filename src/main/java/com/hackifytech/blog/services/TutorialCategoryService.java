package com.hackifytech.blog.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackifytech.blog.models.TutorialCategory;
import com.hackifytech.blog.repositories.TutorialCategoryRepository;

@Service
public class TutorialCategoryService {

    @Autowired
    private TutorialCategoryRepository tutorialCategoryRepository;

    public List<TutorialCategory> getAllTutorialCategories() {
        return tutorialCategoryRepository.findAll();
    }

    public Optional<TutorialCategory> getTutorialCategoryById(Long id) {
        return tutorialCategoryRepository.findById(id);
    }

    public TutorialCategory createTutorialCategory(TutorialCategory category) {
        category.setCreatedAt(new Date());
        return tutorialCategoryRepository.save(category);
    }

    public TutorialCategory updateTutorialCategory(Long id, TutorialCategory category) {
        Optional<TutorialCategory> existingCategoryOpt = getTutorialCategoryById(id);
        if (existingCategoryOpt.isPresent()) {
            TutorialCategory existingCategory = existingCategoryOpt.get();
            existingCategory.setCategoryTitle(category.getCategoryTitle());
            existingCategory.setCategoryDescription(category.getCategoryDescription());
            existingCategory.setUpdatedAt(new Date());
            return tutorialCategoryRepository.save(existingCategory);
        } else {
            return null; // Or handle the case where the category is not found
        }
    }

    public void deleteTutorialCategory(Long id) {
        Optional<TutorialCategory> existingCategoryOpt = getTutorialCategoryById(id);
        if (existingCategoryOpt.isPresent()) {
            tutorialCategoryRepository.deleteById(id);
        }
    }
}
