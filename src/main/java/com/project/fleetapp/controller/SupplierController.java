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

import com.project.fleetapp.models.State;
import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.services.StateService;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.CountryService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	

	@GetMapping("/supplier")
	public String getSuppliers(Model model) {
		List<Supplier> supplierList = supplierService.getSupplierList();
		model.addAttribute("supplier", supplierList);
		
		List<State> stateList = stateService.getStateList();
		model.addAttribute("state", stateList);
		
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);
		return "Supplier";
	}
	
	@PostMapping("/supplier/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findByid(int id) {
		return supplierService.findById(id);
	}
	
	@RequestMapping(value="/supplier/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	

	@RequestMapping(value="/supplier/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(int id) {
		supplierService.delete(id);
		return "redirect:/supplier";
	}	
}
