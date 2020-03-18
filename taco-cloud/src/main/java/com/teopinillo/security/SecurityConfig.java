package com.teopinillo.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

//Notes: StandardPAsswordEncoder is not considered secure.
//{@link https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/password/StandardPasswordEncoder.html
//
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private UserDetailsService userDetailsService;
	 
	 @Bean
	 public PasswordEncoder encoder() {
		 return new StandardPasswordEncoder ("53cr3t");
	 }
	 
	 @Override
	 protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		  auth
		  .userDetailsService (userDetailsService)
		  .passwordEncoder(encoder());		  
		  
		  
	 }
}
