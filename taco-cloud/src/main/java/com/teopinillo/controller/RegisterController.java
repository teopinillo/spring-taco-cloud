package com.teopinillo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teopinillo.data.UserRepository;
import com.teopinillo.entity.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

	public RegisterController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public String registerForm() {
		return "registration";
	}
	
	@PostMapping
	public String processRegistration (RegistrationForm form) {
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}
}
