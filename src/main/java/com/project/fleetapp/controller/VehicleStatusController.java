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

import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehicleStatus")
	public String getVehicleStatus(Model model) {
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatusList();
		model.addAttribute("vehicleStatus", vehicleStatusList);
		return "VehicleStatus";
	}
	
	@PostMapping("/vehicleStatus/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	@RequestMapping("/vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findByid(Integer id) {
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value="/vehicleStatus/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	

	@RequestMapping(value="/vehicleStatus/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatus";
	}
}
