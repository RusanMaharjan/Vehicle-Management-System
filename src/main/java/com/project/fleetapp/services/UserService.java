package com.project.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.User;
import com.project.fleetapp.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		
		userRepository.save(user);
	}
}
