package com.myWebApp.coursemanagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "course")
public class Course {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "title")
	private String title;
	
	@Column (name = "author")
	private String author;
	
	@Column (name = "category")
	private String category;
	
	@Column (name = "publish_date")
	private LocalDateTime  publishDate;
}
