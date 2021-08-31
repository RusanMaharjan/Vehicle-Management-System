package com.project.fleetapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.models.VehicleMovement;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleMovementService;
import com.project.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private LocationService locationService;
	
	
	@GetMapping("/vehicleMovement")
	public String getVehicleMovement(Model model) {
		
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovementList();
		model.addAttribute("vehicleMovement", vehicleMovementList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		model.addAttribute("vehicle", vehicleList);
		
		List<Location> locationList = locationService.getLocationList();
		model.addAttribute("location", locationList);
		return "VehicleMovement";
	}
	
	
	@PostMapping("/vehicleMovement/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}
	
	@RequestMapping("/vehicleMovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id){
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMovement/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}
	
	@RequestMapping(value="/vehicleMovement/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(int id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovement";
	}
}
