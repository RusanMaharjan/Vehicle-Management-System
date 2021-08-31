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
import com.project.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicleType")
	public String getVehicleTypes(Model model) {
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypeList();
		model.addAttribute("vehicleType", vehicleTypeList);
		return "VehicleType";
	}
	
	@PostMapping("/vehicleType/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleType";
	}
	
	@RequestMapping("/vehicleType/findById")
	@ResponseBody
	public Optional<VehicleType> findByid(Integer id) {
		return vehicleTypeService.findById(id);
	}
	
	@RequestMapping(value="/vehicleType/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleType";
	}
	

	@RequestMapping(value="/vehicleType/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleType";
	}
}
