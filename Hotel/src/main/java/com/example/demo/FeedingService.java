package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Feeding;
import com.example.demo.model.Room;
import com.example.demo.repository.FeedingRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class FeedingService {
	
	private final FeedingRepository feedingRepository;
	
    public FeedingService(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    public List<String> listTypeFood() {
        // Recupere os dados do repositório e retorne apenas o atributo desejado
        List<Feeding> objetos = (List<Feeding>) feedingRepository.findAll();
        return objetos.stream()
                      .map(objeto -> objeto.gettypeFood())
                      .collect(Collectors.toList());
    }
}
