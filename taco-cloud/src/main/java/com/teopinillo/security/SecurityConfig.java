package com.teopinillo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 }
	   
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("buzz")
		.password("{noop}infinity")
		.authorities("USER");
		
		auth
		.inMemoryAuthentication()
		.withUser("teopinillo")
		.password("{noop}admin")
		.authorities("ADMIN","WRITE_PRIVILEGES","READ_PRIVILEGES")
		.credentialsExpired(true)
		.accountExpired(true)
		.accountLocked(true);
		
		auth
		.inMemoryAuthentication()
		.withUser("woody")
		.password("{noop}bullseye")
		.authorities("USER");		
	}
}
