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

import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobTitle")
	public String getJobTitles(Model model) {
		List<JobTitle> jobTitleList = jobTitleService.getJobTitleList();
		model.addAttribute("jobTitle", jobTitleList);
		return "JobTitle";
	}
	
	@PostMapping("/jobTitle/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}
	
	@RequestMapping("/jobTitle/findById")
	@ResponseBody
	public Optional<JobTitle> findByid(Integer id) {
		return jobTitleService.findById(id);
	}
	
	@RequestMapping(value="/jobTitle/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}
	

	@RequestMapping(value="/jobTitle/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitle";
	}
}
