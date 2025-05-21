package com.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/hello")
	public String getMsg() {
		return "hello ";
	}
	
	@GetMapping("/greet")
	public String getGreet() {
		return "Good Morning";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return" call : +91 22 22 2222 22";
	}
}
