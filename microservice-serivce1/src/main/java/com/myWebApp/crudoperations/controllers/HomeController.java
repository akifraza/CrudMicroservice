package com.myWebApp.crudoperations.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping ("/getData-1")
	public String getdata() {
		return "Service-1";
	}
}
