package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//return list of vehicle
	public List<Vehicle> getVehicleList(){
		return vehicleRepository.findAll();
	}

	//save new vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	//get by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
}
