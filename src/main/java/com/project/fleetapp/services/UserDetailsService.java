package com.project.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.User;
import com.project.fleetapp.models.UserPrincipal;
import com.project.fleetapp.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByusername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}

}
