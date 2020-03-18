package com.teopinillo.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;
	 
	 @Override
	 protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		  auth
		  .ldapAuthentication()
		  .userSearchFilter("(uid={0})")
		  .groupSearchFilter("member={0}");
		  
	 }
}

