package com.ey.starter.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.ey.starter.model.Role;

public class UserDTO {
	
	@NotEmpty(message = "Email está vazio")
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = "Password está vazio")
	private String password;
	
	@NotEmpty(message = "Enable está vazio")
	private boolean enable;
	
	@NotEmpty(message = "Roles está vazio")
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
