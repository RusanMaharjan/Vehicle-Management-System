package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.repository.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//return list of vehicleType
	public List<VehicleType> getVehicleTypeList(){
		return vehicleTypeRepository.findAll();
	}

	//save new vehicleType
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	//get by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}
}
