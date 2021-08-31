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

import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoiceStatus")
	public String getInvoiceStatus(Model model) {
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatusList();
		model.addAttribute("invoiceStatus", invoiceStatusList);
		return "InvoiceStatus";
	}
	
	@PostMapping("/invoiceStatus/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatus";
	}
	
	@RequestMapping("/invoiceStatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findByid(int id) {
		return invoiceStatusService.findById(id);
	}
	
	@RequestMapping(value="/invoiceStatus/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatus";
	}
	

	@RequestMapping(value="/invoiceStatus/delete", method= {RequestMethod.PUT, RequestMethod.GET})
	public String delete(int id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatus";
	}
}
