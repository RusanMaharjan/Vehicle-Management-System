package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.repository.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//return list of vehicleModel
	public List<VehicleModel> getVehicleModelList(){
		return vehicleModelRepository.findAll();
	}

	//save new vehicleModel
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	//get by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
	}
}
