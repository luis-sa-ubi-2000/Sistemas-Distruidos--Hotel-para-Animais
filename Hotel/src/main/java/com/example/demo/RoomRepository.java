package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository
//CRUD refers Create, Read, Update, Delete

public interface RoomRepository extends CrudRepository<Room, Long>{
	 @Query("SELECT r FROM Room r WHERE r.type = :roomType")
	    List<Room> findByType(String roomType);
}
