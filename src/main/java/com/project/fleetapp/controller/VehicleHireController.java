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

import com.project.fleetapp.models.Client;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.models.VehicleHire;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleHireService;
import com.project.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/vehicleHire")
	public String getVehicleHire(Model model) {

		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHireList();
		model.addAttribute("vehicleHire", vehicleHireList);

		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		model.addAttribute("vehicle", vehicleList);

		List<Location> locationList = locationService.getLocationList();
		model.addAttribute("location", locationList);
		
		List<Client> clientList = clientService.getClientList();
		model.addAttribute("client", clientList);
		return "VehicleHire";
	}

	@PostMapping("/vehicleHire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping("/vehicleHire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);
	}

	@RequestMapping(value = "/vehicleHire/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping(value = "/vehicleHire/delete", method = { RequestMethod.PUT, RequestMethod.GET })
	public String delete(int id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHire";
	}
}
