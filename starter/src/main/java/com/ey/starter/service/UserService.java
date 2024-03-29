package com.ey.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ey.starter.dto.UserDTO;
import com.ey.starter.model.Role;
import com.ey.starter.model.User;
import com.ey.starter.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(UserDTO userDTO)  {
		//if role different to user (2) then its invalid
		for (Role role : userDTO.getRoles()) {
			if (role.getRoleId() != 2) {
				return null;
			}
		}
		
		return saveUser(userDTO);
		
	}
	
	public User addUserAdmin(UserDTO userDTO) {
		return saveUser(userDTO);
	}
	
	private User saveUser( UserDTO userDTO) {
		
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setEnable(userDTO.isEnable());
		if ( !userDTO.getPassword().isEmpty()) {
			String pass = passwordEncoderLogin().encode(userDTO.getPassword());			
			user.setPassword(pass);
		}
		
		user.setRoles(userDTO.getRoles());
		
		return userRepository.save(user); 
	}
	
	
	@Bean
    public PasswordEncoder passwordEncoderLogin() {
        return new BCryptPasswordEncoder();
    }

}
