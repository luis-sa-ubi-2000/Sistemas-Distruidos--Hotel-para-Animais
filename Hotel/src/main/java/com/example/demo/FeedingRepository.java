package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Long>{
 	
	
	@Query(value= "SELECT p.specie, f.typeFood " +
	           "FROM Pet p " +
	           "JOIN Feeding f ON p.id = f.pet.id " +
	           "GROUP BY p.specie, f.typeFood " +
	           "HAVING COUNT() = (" +
	           "  SELECT MAX(count_per_species) " +
	           "  FROM (" +
	           "    SELECT p.specie, f.typeFood, COUNT() AS count_per_species " +
	           "    FROM Pet p " +
	           "    JOIN Feeding f ON p.id = f.pet.id " +
	           "    GROUP BY p.specie, f.typeFood" +
	           "  ) AS counts " +
	           "  WHERE counts.specie = p.specie" +
	           ")", nativeQuery = true)
    	List<Object[]> mostRequestedTypeOfFoodBySpecie();
 	
 	/* "SELECT p.specie, f.typeFood, COUNT(*) AS quantidade" +
			"FROM Feeding f " +
			"INNER JOIN f.pet p " +
			"GROUP BY p.specie, f.typeFood " +
			"HAVING quantidade = ( " +
			"SELECT MAX(quantidade) " +
			"FROM (" +
			"SELECT COUNT(*) AS quantidade " +
			"FROM Feeding ff " +
			"JOIN ff.pet pp " +
			"WHERE ff.typeFood = f.typeFood " +
			"GROUP BY pp.specie, ff.typeFood " +
			") AS subquery " +
			") "*/

}