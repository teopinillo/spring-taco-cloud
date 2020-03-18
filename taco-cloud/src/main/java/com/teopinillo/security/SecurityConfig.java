package com.teopinillo.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

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
	 
	 //By default Spring Security required user authentication.
	 //But login and registration page should be available to unauthenticated users.
	 // - Requiring that certain security conditions be met before allowing a request to be served
	 // - Configuring a custom login page
	 // - Enabling users to log out of the application
	 // - Configuring cross-site request forgery protection
	 @Override
	 protected void configure (HttpSecurity httpSecurity) throws Exception {
		 
		 //ensure that requests for /design and /orders are only available to authenticated users
		 
		 httpSecurity
		 .authorizeRequests()
		 .antMatchers("/design","/orders")
		 .hasRole("USER")
		 .antMatchers("/","/**").permitAll()
		 .and()
		 .formLogin()		//defines custom login page
		 .loginPage("/login");
		 
		 // Configuration methods to define how a path is to be secured
		 // access(String) 			Allows access if the given SpEL expression evaluates to true
		 // anonymous() 				Allows access to anonymous users
		 // authenticated() 			Allows access to authenticated users
		 // denyAll() 				Denies access unconditionally
		 // fullyAuthenticated() 	Allows access if the user is fully authenticated (not remembered)
		 // hasAnyAuthority(String…) Allows access if the user has any of the given authorities
		 // hasAnyRole(String…) 		Allows access if the user has any of the given roles
		 // hasAuthority(String) 	Allows access if the user has the given authority
		 // hasIpAddress(String) 	Allows access if the request comes from the given IP a
		 // hasRole(String) Allows access if the user has the given role
		 // not() Negates the effect of any of the other access methods
		 // permitAll() Allows access unconditionally
		 // rememberMe() Allows access for users who are authenticated via remember-me
		 
	 }
	 	 
}
