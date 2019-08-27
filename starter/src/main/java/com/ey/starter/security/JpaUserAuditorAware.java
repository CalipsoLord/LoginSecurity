package com.ey.starter.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JpaUserAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		
		if (aut != null) {
			return Optional.of(aut.getName());
		} 
		
		return Optional.ofNullable("User_default");
	}
	
	

}
