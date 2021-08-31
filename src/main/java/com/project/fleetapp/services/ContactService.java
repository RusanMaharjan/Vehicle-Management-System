package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Contact;
import com.project.fleetapp.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//return list of contact
	public List<Contact> getContactList(){
		return contactRepository.findAll();
	}

	//save new contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	//get by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}	
}
