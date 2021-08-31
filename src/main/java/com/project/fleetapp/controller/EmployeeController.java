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
import com.project.fleetapp.models.Employee;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.EmployeeService;
import com.project.fleetapp.services.EmployeeTypeService;
import com.project.fleetapp.services.JobTitleService;
import com.project.fleetapp.services.StateService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/employee")
	public String getEmployees(Model model) {
		List<Employee> employeeList = employeeService.getEmployeeList();
		model.addAttribute("employee", employeeList);
		
		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);
		
		model.addAttribute("jobTitle", jobTitleService.getJobTitleList());
		model.addAttribute("employeeType", employeeTypeService.getEmployeeTypeList());
		model.addAttribute("state", stateService.getStateList());
		return "Employee";
	}
	
	@PostMapping("/employee/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> findByid(Integer id) {
		return employeeService.findById(id);
	}
	
	@RequestMapping(value="/employee/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	

	@RequestMapping(value="/employee/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employee";
	}
}
