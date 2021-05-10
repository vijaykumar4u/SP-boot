package com.vijay.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Seucrity_TestController {

	@GetMapping("/")
	public String globalAccess() {
		return "<h1>Welocome  Global Access</h1>";
	}

	@GetMapping("/user")
	public String userAccess() {
		return "<h1>Welocome User Access</h1>";
	}

	@GetMapping("/admin")
	public String adminAccess() {
		return "<h1>Welocome Admin Access</h1>";
	}

}
