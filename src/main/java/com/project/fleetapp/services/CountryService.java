package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//return list of countries
	public List<Country> getCountryList(){
		return countryRepository.findAll();
	}

	//save new country
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	//get by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}


}
