package com.hackifytech.blog.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackifytech.blog.models.CategoryTag;
import com.hackifytech.blog.repositories.CategoryTagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryTagService {

	@Autowired
    private CategoryTagRepository categoryTagRepository;

    public List<CategoryTag> getAllCategoryTags() {
        return categoryTagRepository.findAll();
    }

    public Optional<CategoryTag> getCategoryTagById(Long id) {
        return categoryTagRepository.findById(id);
    }

    public CategoryTag createCategoryTag(CategoryTag categoryTag) {
        return categoryTagRepository.save(categoryTag);
    }

    public void deleteCategoryTag(Long id) {
        categoryTagRepository.deleteById(id);
    }
}