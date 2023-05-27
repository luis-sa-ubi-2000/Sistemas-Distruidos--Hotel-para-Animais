package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private PetRepository petRepository;
    

    

    @GetMapping(path = "/")
    public String showLoginForm(Model model) {
        return "login";
    }
    
    @GetMapping(path = "/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registersave")
    public String registerUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null && error.equals("true")) {
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
        	if(user.getRole().equals(UserRole.HOTEL_MANAGER)) {
        		session.setAttribute("admin", user);
        		return "redirect:/mainpage";
        	} else {
        		session.setAttribute("client", user);
                return "redirect:/mainpageclient";
        	}
        } else {
            return "redirect:/login?error=true";
        }
    }
    
    @GetMapping(path="/mainpage")
	public String showMainAdminPage(HttpSession session, Model model) {
    	User user = (User) session.getAttribute("admin");
        if (user != null) {
            model.addAttribute("user", user);
            return "mainpage";
        } else {
            return "redirect:/login";
        }
	}

    @GetMapping("/mainpageclient")
    public String showDashboard(HttpSession session, Model model) {
    	int encontrado = 0;
        User user = (User) session.getAttribute("client");
        List<Client> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(clientList::add);
        int clientCount = clientList.size();
        if (user != null) {
            model.addAttribute("user", user);
            for(int i = 0; i < clientCount; i++) {
            	if(clientList.get(i).getUser() != null) {
            		if(clientList.get(i).getUser().getId() == user.getId()) {
                		encontrado = 1;
                    	model.addAttribute("client", clientList.get(i));
                    	model.addAttribute("pets", clientList.get(i).getPets());
                    }
            	}
            }
            if(encontrado == 0) {
            	// create model attribute to bind form data
           	 	Client client = new Client();
           	 	model.addAttribute("new_client", client);
            }
            return "mainpageclient";
        } else {
            return "redirect:/login";
        }
    }
    
    @PostMapping("/vcsaveClient")
    public String saveClientVC(@ModelAttribute("client") Client client) {
        if (client.getId() == null) {
            // Create a new client
            clientRepository.save(client);
        } else {
            // Update an existing client
            Client existingClient = clientRepository.findById(client.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

            // Update the existing client with the new values
            existingClient.setName(client.getName());
            existingClient.setAddress(client.getAddress());
            existingClient.setPhone(client.getPhone());

            clientRepository.save(existingClient);
        }

        return "redirect:/mainpageclient";
    }

    
    
    @GetMapping("/vcupdateclient/{clientId}")
    public String showUpdateClientPageVC(@PathVariable("clientId") Long clientId, Model model) {
        // Retrieve the client from the database based on the provided clientId
        Client client = clientRepository.findById(clientId).orElse(null);
        
        if (client != null) {
            model.addAttribute("client", client);
            return "vcupdateclient";
        } else {
            // Client not found, handle the error accordingly
            // You can redirect to an error page or display an error message
            return "error";
        }
    }
    
    
    @GetMapping("/pets/delete/{id}")
    public String deletePetVC(@PathVariable(value = "id") Long id) {
        petRepository.deleteById(id);
        return "redirect:/mainpageclient";
    }

    
    @GetMapping("/showVCNewPetForm")
    public String showNewPetForm(Model model) {
        model.addAttribute("new_pet", new Pet());
        return "vcnewpetclient";
    }
    
    @PostMapping("/vcsavePet")
    public String savePetVC(@ModelAttribute("new_pet") Pet pet, HttpSession session) {
        User user = (User) session.getAttribute("client");
        List<Client> clientList = new ArrayList<>();
        Client client = null;
        clientRepository.findAll().forEach(clientList::add);
        int clientCount = clientList.size();
        for(int i = 0; i < clientCount; i++) {
            if(clientList.get(i).getUser() != null) {
                if(clientList.get(i).getUser().getId() == user.getId()) {
                    client = clientList.get(i);
                }
            }
        }

        pet.setClient(client); // Assign the client to the pet object

        if (pet.getId() == null) {
            // Create a new pet
            petRepository.save(pet);
        } else {
            // Update an existing pet
            Pet existingPet = petRepository.findById(pet.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid pet ID"));

            // Update the existing pet with the new values
            existingPet.setAge(pet.getAge());
            existingPet.setName(pet.getName());
            existingPet.setRace(pet.getRace());
            existingPet.setSpecie(pet.getSpecie());
            existingPet.setClient(client);

            petRepository.save(existingPet);
        }

        return "redirect:/mainpageclient";
    }



    
    




}

