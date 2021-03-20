package com.myWebApp.uesrmanagement.service;

import java.util.List;

import com.myWebApp.uesrmanagement.model.User;

public interface UserService {

	User save(User user);

	User findByUsername(String username);

 	List<String> findUsers(List<Long> idList);

}
