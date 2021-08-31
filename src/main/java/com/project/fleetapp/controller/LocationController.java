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
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;
	
	
	@GetMapping("/location")
	public String getLocations(Model model) {
		List<Location> locationList = locationService.getLocationList();
		model.addAttribute("location", locationList);
		
		List<State> stateList = stateService.getStateList();
		model.addAttribute("state", stateList);
		
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);
		return "Location";
	}
	
	@PostMapping("/location/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findByid(Integer id) {
		return locationService.findById(id);
	}
	
	@RequestMapping(value="/location/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	

	@RequestMapping(value="/location/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/location";
	}
	
	
}
