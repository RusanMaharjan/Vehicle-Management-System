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
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;

	@GetMapping("/state")
	public String getStates(Model model) {
		List<State> stateList = stateService.getStateList();
		model.addAttribute("state", stateList);
		
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);
		return "State";
	}
	
	@PostMapping("/state/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> findByid(Integer id) {
		return stateService.findById(id);
	}
	
	@RequestMapping(value="/state/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	

	@RequestMapping(value="/state/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/state";
	}
	
	
}
