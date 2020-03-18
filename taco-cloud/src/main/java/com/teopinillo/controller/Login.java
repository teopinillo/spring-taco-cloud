package com.teopinillo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Login {
	
	@GetMapping	//handle request for  the root path
	public String home() {
		return "login";		//returns the view name
	}

}
