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

import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehicleModel")
	public String getVehicleModels(Model model) {
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModelList();
		model.addAttribute("vehicleModel", vehicleModelList);
		return "VehicleModel";
	}
	
	@PostMapping("/vehicleModel/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	@RequestMapping("/vehicleModel/findById")
	@ResponseBody
	public Optional<VehicleModel> findByid(Integer id) {
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value="/vehicleModel/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}
	

	@RequestMapping(value="/vehicleModel/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehicleModel";
	}	
}
