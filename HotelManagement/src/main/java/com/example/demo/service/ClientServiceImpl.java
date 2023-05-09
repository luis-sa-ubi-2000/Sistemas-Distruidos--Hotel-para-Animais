package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository  clientRepository;

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

}
