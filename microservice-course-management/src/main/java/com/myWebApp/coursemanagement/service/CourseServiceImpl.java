package com.myWebApp.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWebApp.coursemanagement.repository.CourseRepository;
import com.myWebApp.coursemanagement.repository.TransactionRepository;

import com.myWebApp.coursemanagement.model.Course;
import com.myWebApp.coursemanagement.model.Transaction;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Course> allCourses() {
		return courseRepository.findAll();
	}
	
	
	@Override
	public Course findCourseById (Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}
	
	@Override
	public List<Transaction> findTransactionsOfUser (Long userId) {
		return transactionRepository.findAllByUserId(userId);
		
	}
	
	@Override
	public List<Transaction> findTransactionsOfCourse (Long courseId) {
		return transactionRepository.findAllByCourseId(courseId);
	}
	
	@Override
	public Transaction saveTransaction (Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}
