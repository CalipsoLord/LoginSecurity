package com.ey.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.starter.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//TODO ver
	User findByEmail(String email);
	

}
