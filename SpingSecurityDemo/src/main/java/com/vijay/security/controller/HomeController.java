package com.vijay.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/public")
	public String publicPage() {
		return "public";
	}

	@GetMapping("/private")
	public String privatPage() {
		return "private";
	}

}
