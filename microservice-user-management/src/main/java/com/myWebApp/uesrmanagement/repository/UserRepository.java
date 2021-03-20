package com.myWebApp.uesrmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myWebApp.uesrmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


	Optional<User> findByUsername (String username);
	
	@Query ("SELECT u.name FROM User u WHERE u.id in (:pIdList)")
	List<String> findByIdList (@Param("pIdList") List<Long> pIdList);

}
