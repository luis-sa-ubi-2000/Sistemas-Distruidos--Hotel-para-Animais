package com.example.demo;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller // This means that this class is a Controller
public class MainController {

	// Static Methods

	public static boolean insertedAInterval(DateForm dateForm) {
		if (dateForm.getBegin().isEqual(LocalDate.of(0, 1, 1))) {
			return false;
		} else {
			return true;
		}
	}

	// Variables
	DateForm initDate = new DateForm();

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private LodgingRepository lodgingRepository;

	@Autowired
	private RoomRepository roomRepository;


	@Autowired
	private FeedingRepository feedingRepository;



	// 1. ------------------------- Entidades --------------------------------------

	// 1.1 ----- Client -------

	@GetMapping("/showClient")
	public String showClient(Model model) {
		model.addAttribute("ListClients", clientRepository.findAll());
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
	public String saveClient(@ModelAttribute("newclient") Client client) {
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
		Optional<Client> optional = clientRepository.findById(id);
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
		model.addAttribute("ListPets", petRepository.findAll());
		return "pet";
	}

	@GetMapping("/showNewPetForm")
	public String showNewPetForm(Model model) {
		model.addAttribute("ListClients", clientRepository.findAll());
		Pet pet = new Pet();
		model.addAttribute("new_pet", pet);
		return "new_pet";
	}

	@PostMapping("/savePet")
	public String savePet(@ModelAttribute("newclient") Pet pet) {
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
		Optional<Pet> optional = petRepository.findById(id);
		Pet pet = null;
		if (optional.isPresent()) {
			pet = optional.get();
		} else {
			throw new RuntimeException(" Pet not found for id :: " + id);
		}
		// set pet as a model attribute to pre-populate the form
		model.addAttribute("update_pet", pet);
		model.addAttribute("ListClients", clientRepository.findAll());
		return "update_pet";
	}

	// 1.3 ----- Room -----

	@GetMapping("/showRoom")
	public String showRoom(Model model) {
		model.addAttribute("ListRooms", roomRepository.findAll());
		return "room";
	}

	@GetMapping("/showNewRoomForm")
	public String showNewRoomForm(Model model) {
		model.addAttribute("ListRoom", roomRepository.findAll());
		Room room = new Room();
		model.addAttribute("new_room", room);
		return "new_room";
	}

	@PostMapping("/saveRoom")
	public String saveRoom(@ModelAttribute("newroom") Room room) {
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
		Optional<Room> optional = roomRepository.findById(id);
		Room room = null;
		if (optional.isPresent()) {
			room = optional.get();
		} else {
			throw new RuntimeException(" Room not found for id :: " + id);
		}
		model.addAttribute("update_room", room);
		return "update_room";
	}

	// 2. --------------------- Services ----------------------------------

	// 2.1 ----- Accomodation -------

	@GetMapping(path = "/showLodgings")
	public String showLodgings(Model model) {
		model.addAttribute("ListLodgings", lodgingRepository.findAll());
		return "lodgings";
	}

	@GetMapping("/deleteLodging/{id}")
	public String deleteLodging(@PathVariable(value = "id") Long id) {
		lodgingRepository.deleteById(id);
		return "redirect:/showLodgings";
	}

	// 2.2 ----- Feeding -------

	@GetMapping(path = "/showFeeding")
	public String showFeeding(Model model) {
		model.addAttribute("ListFeeding", feedingRepository.findAll());
		return "feeding";
	}

	@GetMapping("/showNewFeedingForm")
	public String showNewFeedingForm(Model model) {
		model.addAttribute("ListPets", petRepository.findAll());
		List<String> listTypeFood = new ArrayList<>();
		Feeding feed = new Feeding();
		model.addAttribute("new_feeding", feed);
		listTypeFood.add("Dry Food");
		listTypeFood.add("Canned Food");
		listTypeFood.add("Raw Food");
		model.addAttribute("ListTypeFood", listTypeFood);
		return "new_feeding";
	}

	@PostMapping("/saveFeeding")
	public String saveFeeding(@ModelAttribute("newfeeding") Feeding feed) {
		// save feed to database
		feedingRepository.save(feed);
		return "redirect:/showFeeding";
	}

	@GetMapping("/deleteFeeding/{id}")
	public String deleteFeeding(@PathVariable(value = "id") Long id) {
		feedingRepository.deleteById(id);
		return "redirect:/showFeeding";
	}


	// 3. --------------------- Statistics ----------------------------------
	
	// 3.1 -------------------- LodgingCountBySpecie --------------------------

	@GetMapping("/showSpeciesStatistics")
	public String countLodgingsBySpecies(Model model) {

		List<Object[]> results = petRepository.findLodgingCountBySpecie();

		List<StatisticSpecie> statisticSpecieCounts = new ArrayList<>();
		for (Object[] result : results) {
			StatisticSpecie statisticSpecieCount = new StatisticSpecie();
			statisticSpecieCount.setSpecie((String) result[0]);
			statisticSpecieCount.setCount((Long) result[1]);
			statisticSpecieCounts.add(statisticSpecieCount);
		}

		// Verify if user was already give a interval of time
		if (insertedAInterval(initDate)) {
			List<Object[]> resultsInterval = petRepository.findPetSpeciesCountByLodgingDate(initDate.getBegin(),
					initDate.getEnd());

			List<StatisticSpecie> statisticSpecieCountsInterval = new ArrayList<>();
			for (Object[] result : resultsInterval) {
				StatisticSpecie statisticSpecieCountInterval = new StatisticSpecie();
				statisticSpecieCountInterval.setSpecie((String) result[0]);
				statisticSpecieCountInterval.setCount((Long) result[1]);
				statisticSpecieCountsInterval.add(statisticSpecieCountInterval);
			}

			model.addAttribute("lodgingCountsInterval", statisticSpecieCountsInterval);
		}

		model.addAttribute("dateForm", initDate);
		model.addAttribute("lodgingCounts", statisticSpecieCounts);
		return "statistic_species";
	}

	@PostMapping("/processSpeciesStatistics")
	public String processForm(DateForm dateForm, Model model) {
		// Process the form data here
		LocalDate beginDate = dateForm.getBegin();
		LocalDate endDate = dateForm.getEnd();

		initDate.setBegin(beginDate);
		initDate.setEnd(endDate);
		return "redirect:/showSpeciesStatistics";
	}
	
	// 3.2 -------------------- MostRequestedTypeOfFoodPerSpecie --------------------------
	
    
				@GetMapping("/showTypeOfFoodStatistics")
				public String mostRequestTypeOfFood(Model model) {
					
					List<Object[]> results = feedingRepository.mostRequestedTypeOfFoodBySpecie();

			        List<StatisticFood> statisticFoodBySpecies = new ArrayList<>();
			        for (Object[] result : results) {
			        	StatisticFood statisticFoodBySpecie = new StatisticFood();
			        	statisticFoodBySpecie.setSpecie((String) result[0]);
			        	statisticFoodBySpecie.settypeFood((String) result[1]);
			        	statisticFoodBySpecies.add(statisticFoodBySpecie);
			        }
			        
					model.addAttribute("feedingStatistic", statisticFoodBySpecies);
					return "statistic_feeding";
				}
	
}