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

import com.project.fleetapp.models.Contact;
import com.project.fleetapp.services.ContactService;


@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String getContacts(Model model) {
		List<Contact> contactList = contactService.getContactList();
		model.addAttribute("contact", contactList);
		return "Contact";
	}

	@PostMapping("/contact/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}

	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findByid(int id) {
		return contactService.findById(id);
	}

	@RequestMapping(value = "/contact/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}

	@RequestMapping(value = "/contact/delete", method = { RequestMethod.PUT, RequestMethod.GET })
	public String delete(int id) {
		contactService.delete(id);
		return "redirect:/contact";
	}
	
}
