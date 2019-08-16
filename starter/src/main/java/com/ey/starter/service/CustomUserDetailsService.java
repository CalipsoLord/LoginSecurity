package com.ey.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ey.starter.model.User;
import com.ey.starter.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		CustomUserDetails userDetail = null;
		if (user != null) {
			userDetail = new CustomUserDetails();
			userDetail.setUser(user);
		} else { 
			throw new UsernameNotFoundException("User not found " + username);
		}
		return userDetail;
	}

}
