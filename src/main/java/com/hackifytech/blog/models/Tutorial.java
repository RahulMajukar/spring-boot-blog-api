package com.hackifytech.blog.models;

import java.util.Date;
import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 55)
	private String title;

	@Column(nullable = false, length = 55, unique = true)
	private String slug;

//	min 50 characters 
	@Column(nullable = false, length = 155)
	private String description;

	private String tutorial_order;
	private String sideParent;
	private boolean isPublished;

//	 1 to 3 words | 5 to 10 relevant tags
//	&lt;meta name="keywords" content="HTML introduction, HTML tutorial, HTML basics, how HTML works, HTML installation, HTML execution, HTML tags, HTML elements, HTML attributes"&gt;
	@Column(nullable = false, length = 55)
	private String tags;

	@Column(columnDefinition = "TEXT")
	private String content;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutorial_category_id", nullable = false)
    @JsonBackReference
    private TutorialCategory category;

//	@ManyToOne
//	private User user;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTutorial_order() {
		return tutorial_order;
	}

	public void setTutorial_order(String tutorial_order) {
		this.tutorial_order = tutorial_order;
	}

	public String getSideParent() {
		return sideParent;
	}

	public void setSideParent(String sideParent) {
		this.sideParent = sideParent;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TutorialCategory getCategory() {
		return category;
	}

	public void setCategory(TutorialCategory category) {
		this.category = category;
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
