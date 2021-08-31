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

import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	
	@Autowired
	private VehicleMakeService vehicleMakeService;

	@GetMapping("/vehicleMake")
	public String getVehicleMakes(Model model) {
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakeList();
		model.addAttribute("vehicleMake", vehicleMakeList);
		return "VehicleMake";
	}
	
	@PostMapping("/vehicleMake/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMake";
	}
	
	@RequestMapping("/vehicleMake/findById")
	@ResponseBody
	public Optional<VehicleMake> findByid(Integer id) {
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value="/vehicleMake/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMake";
	}
	

	@RequestMapping(value="/vehicleMake/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMake";
	}	
}
