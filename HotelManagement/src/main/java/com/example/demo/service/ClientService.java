package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Client;

public interface ClientService {
	List<Client> getAllClients();

}
