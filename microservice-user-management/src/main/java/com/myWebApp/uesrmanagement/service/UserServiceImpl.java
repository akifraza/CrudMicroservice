package com.myWebApp.uesrmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myWebApp.uesrmanagement.model.User;
import com.myWebApp.uesrmanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User save (User user) {
		user.setPassword (passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername (String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	

	@Override
	public List<String> findUsers (List<Long> idList) {
		return userRepository.findByIdList(idList);
	}
}
