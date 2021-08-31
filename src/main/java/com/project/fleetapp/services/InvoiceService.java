package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.Invoice;
import com.project.fleetapp.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//return list of invoice
	public List<Invoice> getInvoiceList(){
		return invoiceRepository.findAll();
	}

	//save new invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//get by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
	}

	
}
