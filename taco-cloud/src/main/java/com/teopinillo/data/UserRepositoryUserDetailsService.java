package com.teopinillo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teopinillo.entity.User;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//public UserRepositoryUserDetailsService (UserRepository userRepo) {
	//	this.userRepo = userRepo;
	//}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user!=null) {
			return user;
		}
		throw new UsernameNotFoundException (
				"User '" +username + "' not found");
	}

}
