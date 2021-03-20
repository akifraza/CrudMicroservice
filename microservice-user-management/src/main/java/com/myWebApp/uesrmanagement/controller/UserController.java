package com.myWebApp.uesrmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myWebApp.uesrmanagement.model.Role;
import com.myWebApp.uesrmanagement.model.User;
import com.myWebApp.uesrmanagement.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment env;
	
	@Value ("${spring.application.name}")
	private String serviceId;
	
	@GetMapping ("/service/port")
	public String getPort() {
		return "Service Running on Port : " + env.getProperty("local.server.port");
	}
	
	@PostMapping ("/service/registration")
	public ResponseEntity<?> saveUser (@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			// Status Code 409: Already Exists...
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//Default User Role set to User....
		user.setRole(Role.USER);
		//Save to Database...
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping ("service/login")
	public ResponseEntity<?> getUser (Principal principal) {
		if (principal == null || principal.getName() == null) {
			//This means Logout will be successful. Login?Logout
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return ResponseEntity.ok(userService.findByUsername(principal.getName()));
	}
	
	@PostMapping ("service/names")
	public ResponseEntity<?> getNamesOfUsers(@RequestBody List<Long> idList) {
		return ResponseEntity.ok(userService.findUsers(idList));
	}
	
	@GetMapping ("service/test")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok("It is Working....");
		
	}
}
