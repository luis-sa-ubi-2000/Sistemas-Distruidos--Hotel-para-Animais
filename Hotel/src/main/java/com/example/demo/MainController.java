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
	
	@Autowired
	private LodgingRepository lodgingRepository;
		
	@Autowired
	private RoomRepository roomRepository;
	
	
	@GetMapping(path="/")
	public String showMainPage(Model model) {
		return "mainpage";
	}

	// 1. -------------------------  Entidades  --------------------------------------
	
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
		
		// 1.3 ----- Room -----
		
		@GetMapping("/showRoom")
		public String showRoom(Model model) {
			model.addAttribute("ListRooms" , roomRepository.findAll());
			return "room";
		}
		
		@GetMapping("/showNewRoomForm")
		public String showNewRoomForm(Model model) {
		 model.addAttribute("ListRoom" , roomRepository.findAll());
		 Room room = new Room();
		 model.addAttribute("new_room", room);
		 return "new_room";
		}
		
		
		@PostMapping("/saveRoom")
		public String saveRoom (@ModelAttribute("newroom") Room room ) {
			roomRepository.save(room);
			return "redirect:/showRoom";
		}
		
		@GetMapping("/deleteRoom/{id}")
		public String deleteRoom(@PathVariable(value = "id") Long id) {
			roomRepository.deleteById(id);
			return "redirect:/showRoom";
		}
		
		
		
		@GetMapping("/showUpdateRoomForm/{id}")
		public String showUpdateRoomForm(@PathVariable(value = "id") Long id, Model model) {
			Optional <Room> optional = roomRepository.findById(id);
			Room room = null;
			if (optional.isPresent()) {
				room = optional.get();
			} else {
				throw new RuntimeException(" Room not found for id :: " + id);
			}
			model.addAttribute("update_room", room);
			return "update_room";
		}

		
		// 2. ---------------------  Services  ----------------------------------
		
		// 2.1 ----- Accomodation -------
	
		@GetMapping(path="/showLodgings")
		public String showLodgings(Model model) {
			model.addAttribute("ListLodgings" , lodgingRepository.findAll());
			return "lodgings";
		}
		
		@GetMapping("/showNewLodgingForm")
		public String showNewLodgingForm(Model model) {
		 model.addAttribute("ListPets" , petRepository.findAll());
		 model.addAttribute("ListRooms" , roomRepository.findAll());
		 Lodging lodg = new Lodging();
		 model.addAttribute("new_lodging", lodg);
		 return "new_lodging";
		}
		
		
		
		@PostMapping("/saveLodging")
		public String saveLodging (@ModelAttribute("newlodging") Lodging lodg ) {
			lodgingRepository.save(lodg);
			return "redirect:/showLodgings";
		}
		
		
		@GetMapping("/deleteLodging/{id}")
		public String deleteLodging(@PathVariable(value = "id") Long id) {
		 lodgingRepository.deleteById(id);
			return "redirect:/showLodgings";
		}
		
		
		@GetMapping("/showUpdateLodgingForm/{id}")
		public String showUpdateLodgingForm(@PathVariable(value = "id") Long id, Model model) {
			Optional <Lodging> optional = lodgingRepository.findById(id);
			Lodging lodg = null;
			if (optional.isPresent()) {
				lodg = optional.get();
			} else {
				throw new RuntimeException(" Lodging not found for id :: " + id);
			}
			model.addAttribute("update_lodg", lodg);
			model.addAttribute("ListPets" , petRepository.findAll());
			model.addAttribute("ListRooms" , roomRepository.findAll());
			return "update_lodging";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 3. ---------------------  Statistics  ----------------------------------
		
	    
		@GetMapping("/showSpeciesStatistics")
		public String countLodgingsBySpecies(Model model) {
		    return "statistic_species";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}