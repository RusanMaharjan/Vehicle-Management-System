package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Client;
import com.project.fleetapp.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//return list of client
	public List<Client> getClientList(){
		return clientRepository.findAll();
	}

	//save new client
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	//get by id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}	
}
