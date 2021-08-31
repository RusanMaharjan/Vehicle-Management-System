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

import com.project.fleetapp.models.Client;
import com.project.fleetapp.models.Invoice;
import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.InvoiceService;
import com.project.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	

	@GetMapping("/invoice")
	public String getInvoices(Model model) {
		List<Invoice> invoiceList = invoiceService.getInvoiceList();
		model.addAttribute("invoice", invoiceList);
		
		List<Client> clientList = clientService.getClientList();
		model.addAttribute("client", clientList);
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatusList();
		model.addAttribute("invoiceStatus", invoiceStatusList);
		return "Invoice";
	}
	
	@PostMapping("/invoice/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> findByid(int id) {
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value="/invoice/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	

	@RequestMapping(value="/invoice/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(int id) {
		invoiceService.delete(id);
		return "redirect:/invoice";
	}
	
	
}
