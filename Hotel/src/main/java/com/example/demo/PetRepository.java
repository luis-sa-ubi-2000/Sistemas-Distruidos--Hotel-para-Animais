package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository
//CRUD refers Create, Read, Update, Delete

public interface PetRepository extends CrudRepository<Pet, Long>{
	@Query("SELECT p.specie, COUNT(l.id) " +
	           "FROM Lodging l " +
	           "INNER JOIN l.pet p " +
	           "GROUP BY p.specie")
	List<Object[]> findLodgingCountBySpecie();


}