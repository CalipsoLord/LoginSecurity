package com.ey.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.starter.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
