package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	
	@GetMapping("/test")
	public String greet() {
		return "Hello from Security!";
	}
	
	@GetMapping("/test2")
	public String greetings() {
		return "Hello world!";
	}
}
