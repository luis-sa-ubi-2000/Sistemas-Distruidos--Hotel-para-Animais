package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // This means that this class is a Controller
public class MainController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	
	@GetMapping(path="/")
	public String showMainPage(Model model) {
		return "mainpage";
	}

	// 1. ---------  Entidades  -----------------------
	
	
	// 1.1 ----- Client -------
	
	@GetMapping("/showClient")
	public String showClient(Model model) {
		model.addAttribute("ListClients" , clientRepository.findAll());
		return "client";
	}
	
	@GetMapping("/showNewClientForm")
	public String showNewClientForm(Model model) {
	 // create model attribute to bind form data
	 Client client = new Client();
	 model.addAttribute("new_client", client);
	 return "new_client";
	}
	
	@PostMapping("/saveClient")
	public String saveClient (@ModelAttribute("newclient") Client client ) {
		// save client to database
		clientRepository.save(client);
		return "redirect:/showClient";
	}
	
	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable(value = "id") Long id) {
	 clientRepository.deleteById(id);
		return "redirect:/showClient";
	}
	
	@GetMapping("/showUpdateClientForm/{id}")
	public String showUpdateClientForm(@PathVariable(value = "id") Long id, Model model) {
		Optional <Client> optional = clientRepository.findById(id);
		Client client = null;
		if (optional.isPresent()) {
			client = optional.get();
		} else {
			throw new RuntimeException(" Client not found for id :: " + id);
		}
		// set client as a model attribute to pre-populate the form
		model.addAttribute("update_client", client);
		return "update_client";
	}
	
	// 1.2 ----- Pet -------
	
		@GetMapping("/showPet")
		public String showPet(Model model) {
			model.addAttribute("ListPets" , petRepository.findAll());
			return "pet";
		}
		
		
		
		@GetMapping("/showNewPetForm")
		public String showNewPetForm(Model model) {
		 model.addAttribute("ListClients" , clientRepository.findAll());
		 Pet pet = new Pet();
		 model.addAttribute("new_pet", pet);
		 return "new_pet";
		}
		
		
		
		@PostMapping("/savePet")
		public String savePet (@ModelAttribute("newclient") Pet pet ) {
			// save pet to database
			petRepository.save(pet);
			return "redirect:/showPet";
		}
		
		
		
		@GetMapping("/deletePet/{id}")
		public String deletePet(@PathVariable(value = "id") Long id) {
		 petRepository.deleteById(id);
			return "redirect:/showPet";
		}
		
		
		
		@GetMapping("/showUpdatePetForm/{id}")
		public String showUpdatePetForm(@PathVariable(value = "id") Long id, Model model) {
			Optional <Pet> optional = petRepository.findById(id);
			Pet pet = null;
			if (optional.isPresent()) {
				pet = optional.get();
			} else {
				throw new RuntimeException(" Pet not found for id :: " + id);
			}
			// set pet as a model attribute to pre-populate the form
			model.addAttribute("update_pet", pet);
			model.addAttribute("ListClients" , clientRepository.findAll());
			return "update_pet";
		}
		
		
	
	
}