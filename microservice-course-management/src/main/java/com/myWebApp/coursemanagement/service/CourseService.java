package com.myWebApp.coursemanagement.service;

import java.util.List;

import com.myWebApp.coursemanagement.model.Course;
import com.myWebApp.coursemanagement.model.Transaction;

public interface CourseService {

	List<Course> allCourses();

	Course findCourseById(Long courseId);

	List<Transaction> findTransactionsOfUser(Long userId);

	List<Transaction> findTransactionsOfCourse(Long courseId);

	Transaction saveTransaction(Transaction transaction);

}
