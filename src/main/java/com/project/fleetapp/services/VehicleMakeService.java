package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.repository.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//return list of vehicleMake
	public List<VehicleMake> getVehicleMakeList(){
		return vehicleMakeRepository.findAll();
	}

	//save new vehicleMake
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}
}
