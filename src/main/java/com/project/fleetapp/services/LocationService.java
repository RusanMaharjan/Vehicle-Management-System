package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Location;
import com.project.fleetapp.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	//return list of location
	public List<Location> getLocationList(){
		return locationRepository.findAll();
	}

	//save new location
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}
	
}
