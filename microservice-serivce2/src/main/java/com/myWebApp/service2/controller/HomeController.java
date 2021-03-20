package com.myWebApp.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("getData-2")
	public String getdata() {
		return "Service-2";
	}
}
