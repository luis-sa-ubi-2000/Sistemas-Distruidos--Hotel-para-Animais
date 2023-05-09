package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ClientService;


public class ClientController {
	@Autowired
	private ClientService clientService;
	
	
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listClients", clientService.getAllClients());
		return "index";
	}
}
