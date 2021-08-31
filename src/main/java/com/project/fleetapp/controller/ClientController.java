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
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@GetMapping("/client")
	public String getClients(Model model) {
		List<Client> clientList = clientService.getClientList();
		model.addAttribute("client", clientList);

		List<Country> countryList = countryService.getCountryList();
		model.addAttribute("country", countryList);

		List<State> stateList = stateService.getStateList();
		model.addAttribute("state", stateList);
		return "Client";
	}

	@PostMapping("/client/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}

	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findByid(int id) {
		return clientService.findById(id);
	}

	@RequestMapping(value = "/client/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}

	@RequestMapping(value = "/client/delete", method = { RequestMethod.PUT, RequestMethod.GET })
	public String delete(int id) {
		clientService.delete(id);
		return "redirect:/client";
	}
}
