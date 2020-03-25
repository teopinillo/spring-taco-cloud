package com.teopinillo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
	
	@GetMapping("/")	//handle request for  the root path
	public String home() {
		return "home";		//returns the view name
	}

	@GetMapping("/logout")
	public String logoutSuccess() {
		return "logout";
	}
	
}
