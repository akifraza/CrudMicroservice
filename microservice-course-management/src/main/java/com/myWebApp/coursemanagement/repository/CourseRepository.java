package com.myWebApp.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myWebApp.coursemanagement.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
