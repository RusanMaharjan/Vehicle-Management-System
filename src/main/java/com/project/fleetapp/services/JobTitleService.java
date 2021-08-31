package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.repository.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//return list of jobTitle
	public List<JobTitle> getJobTitleList(){
		return jobTitleRepository.findAll();
	}

	//save new jobTitle
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	//get by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
	}
}
