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

import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.models.VehicleMaintenance;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.VehicleMaintenanceService;
import com.project.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	
	@GetMapping("/vehicleMaintenance")
	public String getVehicleMaintenance(Model model) {
		
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenanceList();
		model.addAttribute("vehicleMaintenance", vehicleMaintenanceList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		model.addAttribute("vehicle", vehicleList);
		
		List<Supplier> supplierList = supplierService.getSupplierList();
		model.addAttribute("supplier", supplierList);
		return "VehicleMaintenance";
	}
	
	
	@PostMapping("/vehicleMaintenance/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	@RequestMapping("/vehicleMaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id){
		return vehicleMaintenanceService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMaintenance/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	@RequestMapping(value="/vehicleMaintenance/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(int id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenance";
	}
}
