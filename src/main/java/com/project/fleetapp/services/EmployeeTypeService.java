package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.repository.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//return list of employeeType
	public List<EmployeeType> getEmployeeTypeList(){
		return employeeTypeRepository.findAll();
	}

	//save new employeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	//get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}
}
