package com.myWebApp.coursemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myWebApp.coursemanagement.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	List<Transaction> findAllByUserId(Long userId);
	
	List<Transaction> findAllByCourseId (Long courseId);
}
