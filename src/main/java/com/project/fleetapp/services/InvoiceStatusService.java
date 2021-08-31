package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.repository.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//return list of invoiceStatus
	public List<InvoiceStatus> getInvoiceStatusList(){
		return invoiceStatusRepository.findAll();
	}

	//save new invoiceStatus
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//get by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}
}
