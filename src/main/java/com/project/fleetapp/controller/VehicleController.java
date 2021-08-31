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

import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.services.VehicleTypeService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleMakeService;
import com.project.fleetapp.services.VehicleModelService;
import com.project.fleetapp.services.VehicleService;
import com.project.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@Autowired
	private LocationService locationService;

	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicle")
	public String getVehicles(Model model) {
		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		model.addAttribute("vehicle", vehicleList);
		
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypeList();
		model.addAttribute("vehicleType", vehicleTypeList);
		
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakeList();
		model.addAttribute("vehicleMake", vehicleMakeList);
		
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatusList();
		model.addAttribute("vehicleStatus", vehicleStatusList);
		
		List<Location> locationList = locationService.getLocationList();
		model.addAttribute("location", locationList);
		
		model.addAttribute("vehicleModel", vehicleModelService.getVehicleModelList());
 		return "Vehicle";
	}
	
	@PostMapping("/vehicle/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findByid(Integer id) {
		return vehicleService.findById(id);
	}
	
	@RequestMapping(value="/vehicle/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	

	@RequestMapping(value="/vehicle/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}
	
}
