package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Long>{
 	
	
<<<<<<< Updated upstream
	@Query("SELECT f.typeFood, COUNT(p.id) AS petCount " +
            "FROM Feeding f " +
            "INNER JOIN f.pet p " +
            "GROUP BY f.typeFood")
    	List<Object[]> countPetsByTypeFood();



=======
	@Query("SELECT p.specie, f.typeFood " +
	           "FROM Feeding f " +
	           "INNER JOIN f.pet p " +
	           "GROUP BY p.specie, f.typeFood " +
	           "ORDER BY COUNT(*) DESC")
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
>>>>>>> Stashed changes

}