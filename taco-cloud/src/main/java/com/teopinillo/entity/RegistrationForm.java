package com.teopinillo.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {

	private String username;
	private String password;
	private String email;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

	//But the toUser() method uses those properties to create a new
	//User object, which is what processRegistration() will save, using the injected User-
	//Repository.
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password),email, fullname, street, city, state, zip, phone);
	}
}
