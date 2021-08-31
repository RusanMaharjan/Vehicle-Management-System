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

import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employeeType")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypeList();
		model.addAttribute("employeeType", employeeTypeList);
		return "EmployeeType";
	}
	
	@PostMapping("/employeeType/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeType";
	}
	
	@RequestMapping("/employeeType/findById")
	@ResponseBody
	public Optional<EmployeeType> findByid(Integer id) {
		return employeeTypeService.findById(id);
	}
	
	@RequestMapping(value="/employeeType/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeType";
	}	

	@RequestMapping(value="/employeeType/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeType";
	}
}
