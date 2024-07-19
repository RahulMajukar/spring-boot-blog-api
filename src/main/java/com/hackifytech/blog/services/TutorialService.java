package com.hackifytech.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackifytech.blog.models.Tutorial;
import com.hackifytech.blog.repositories.TutorialRepository;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

    public List<Tutorial> getTutorialsBySideParent(String sideParent) {
        return tutorialRepository.findBySideParent(sideParent);
    }

    public List<Tutorial>  getPublishedTutorials() {
        return tutorialRepository.findByIsPublished(true);
    }

    public Tutorial getTutorialById(Long id) {
        return tutorialRepository.findById(id).orElse(null);
    }
    
    public List<Tutorial> getTutorialsByCategoryTitle(String categoryTitle) {
        return tutorialRepository.findByCategoryTitle(categoryTitle);
    }

    public Tutorial saveTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
    

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }
}
