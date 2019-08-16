package com.ey.starter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ey.starter.dto.UserDTO;
import com.ey.starter.model.User;
import com.ey.starter.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(@RequestBody UserDTO userDTO) {
		String resp = "token" + userDTO.getEmail() + ":" + userDTO.getPassword();
		return resp;
	}
	
	@RequestMapping(value = "/user" , method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
		
		User userSaved = userService.addUser(userDTO);
		if (userSaved != null) {
			return new ResponseEntity<>(HttpStatus.CREATED);			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public ResponseEntity<?> logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public ResponseEntity<?> user() {
		String resp = "Todos os usuários";
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
}
