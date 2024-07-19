package com.hackifytech.blog.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "tutorial_categories")
public class TutorialCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tutorialCategoryId;

	@Column(name = "title", length = 100, nullable = false,unique = true)
	private String categoryTitle;

	@Column(name = "description")
	private String categoryDescription;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Tutorial> tutorials = new ArrayList<>();

	@Column(nullable = false)
	private Date createdAt;

	@Column
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	public Long getTutorialCategoryId() {
		return tutorialCategoryId;
	}

	public void setTutorialCategoryId(Long tutorialCategoryId) {
		this.tutorialCategoryId = tutorialCategoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
