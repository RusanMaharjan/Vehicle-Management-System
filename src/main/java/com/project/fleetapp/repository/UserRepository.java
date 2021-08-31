package com.project.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fleetapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByusername(String username);
	
}
