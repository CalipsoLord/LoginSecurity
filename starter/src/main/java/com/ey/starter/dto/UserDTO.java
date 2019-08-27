package com.ey.starter.dto;

import java.util.Set;

import com.ey.starter.model.Role;

public class UserDTO {
	
	private String email;
	
	private String password;
	
	private boolean enable;

	private Set<Role> roles;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	} 

}
