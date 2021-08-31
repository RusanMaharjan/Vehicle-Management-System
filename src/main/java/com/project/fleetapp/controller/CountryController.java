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

import com.project.fleetapp.models.Country;
import com.project.fleetapp.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country")
	public String getCountries(Model model) {
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);
		return "country";
	}
	
	@PostMapping("/country/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/country";
	}
	
	@RequestMapping("country/findById")
	@ResponseBody
	public Optional<Country> findByid(Integer id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value="/country/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/country";
	}
	

	@RequestMapping(value="/country/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/country";
	}
	
}
