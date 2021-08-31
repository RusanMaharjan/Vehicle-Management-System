package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.State;
import com.project.fleetapp.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//return list of state
	public List<State> getStateList(){
		return stateRepository.findAll();
	}

	//save new state
	public void save(State state) {
		stateRepository.save(state);
	}
	
	//get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}

	
}
