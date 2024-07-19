package com.hackifytech.blog.models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

//TODO: have to add tags in the post:
//	"tags": [
//	          "history",
//	          "american",
//	          "crime"
//	      ],

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,length = 55)
	private String title;

	@Column(nullable = false, length = 55, unique = true)
	private String slug;
	
	@Column(nullable = false, length = 155)
	private String description;
	
	@Column(nullable = false, length = 55)
	private String tags;
	
	@Column
	private String featuredImage;
	
	@Column
	private String saveAs;

	@Column(columnDefinition = "TEXT")
	private String content;

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getSaveAs() {
		return saveAs;
	}

	public void setSaveAs(String saveAs) {
		this.saveAs = saveAs;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
