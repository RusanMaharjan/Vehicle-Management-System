package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleHire;
import com.project.fleetapp.repository.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//return list of Vehicle Hire
	public List<VehicleHire> getVehicleHireList(){
		return vehicleHireRepository.findAll();
	}
	
	//save new vehicle maintenance
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	//get by id
	public Optional<VehicleHire> findById(int id){
		return vehicleHireRepository.findById(id);
	}
	
	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
	}
}
