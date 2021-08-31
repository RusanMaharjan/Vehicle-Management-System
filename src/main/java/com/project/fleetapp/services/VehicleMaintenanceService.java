package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.VehicleMaintenance;
import com.project.fleetapp.repository.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	//return list of Vehicle Maintenance
	public List<VehicleMaintenance> getVehicleMaintenanceList(){
		return vehicleMaintenanceRepository.findAll();
	}
	
	//save new vehicle maintenance
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	//get by id
	public Optional<VehicleMaintenance> findById(int id){
		return vehicleMaintenanceRepository.findById(id);
	}
	
	public void delete(int id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
