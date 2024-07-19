package com.hackifytech.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackifytech.blog.models.Tutorial;
import com.hackifytech.blog.services.TutorialService;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping
    public List<Tutorial>  getAllTutorials() {
        return tutorialService.getAllTutorials();
    }

    @GetMapping("/sideParent/{sideParent}")
    public List<Tutorial>  getTutorialsBySideParent(@PathVariable String sideParent) {
        return tutorialService.getTutorialsBySideParent(sideParent);
    }

    @GetMapping("/published")
    public List<Tutorial>  getPublishedTutorials() {
        return tutorialService.getPublishedTutorials();
    }
    
    @GetMapping("/category/{categoryTitle}")
    public ResponseEntity<List<Tutorial>> getTutorialsByCategoryTitle(@PathVariable String categoryTitle) {
        List<Tutorial> tutorials = tutorialService.getTutorialsByCategoryTitle(categoryTitle);
        if (tutorials.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tutorials);
        }
    }

    @GetMapping("/{id}")
    public Tutorial getTutorialById(@PathVariable Long id) {
        return tutorialService.getTutorialById(id);
    }

    @PostMapping
    public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.saveTutorial(tutorial);
    }

    @PutMapping("/{id}")
    public Tutorial updateTutorial(@PathVariable Long id, @RequestBody Tutorial tutorial) {
        Tutorial existingTutorial = tutorialService.getTutorialById(id);
        if (existingTutorial != null) {
            existingTutorial.setTitle(tutorial.getTitle());
            existingTutorial.setSlug(tutorial.getSlug());
            existingTutorial.setTutorial_order(tutorial.getTutorial_order());
            existingTutorial.setSideParent(tutorial.getSideParent());
            existingTutorial.setPublished(tutorial.isPublished());
            return tutorialService.saveTutorial(existingTutorial);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTutorial(@PathVariable Long id) {
        tutorialService.deleteTutorial(id);
    }
}