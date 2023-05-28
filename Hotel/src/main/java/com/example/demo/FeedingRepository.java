package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Long>{
 	
	
	 @Query("SELECT f.typeFood, COUNT(p.id) AS petCount " +
	            "FROM Feeding f " +
	            "JOIN f.pet p " +
	            "GROUP BY f.typeFood")
	    List<Object[]> countPetsByTypeFood();




}