package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//return list of supplier
	public List<Supplier> getSupplierList(){
		return supplierRepository.findAll();
	}

	//save new supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}
}
