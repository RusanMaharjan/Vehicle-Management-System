package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleMovement;
import com.project.fleetapp.repository.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//return list of Vehicle Movement
	public List<VehicleMovement> getVehicleMovementList(){
		return vehicleMovementRepository.findAll();
	}
	
	//save new vehicle maintenance
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//get by id
	public Optional<VehicleMovement> findById(int id){
		return vehicleMovementRepository.findById(id);
	}
	
	public void delete(int id) {
		vehicleMovementRepository.deleteById(id);
	}
}
