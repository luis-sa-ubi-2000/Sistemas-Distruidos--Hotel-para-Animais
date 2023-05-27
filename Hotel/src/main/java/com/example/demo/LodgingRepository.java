package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository
//CRUD refers Create, Read, Update, Delete

public interface LodgingRepository extends CrudRepository<Lodging, Long>{
	 @Query("SELECT COUNT(l) FROM Lodging l " +
	           "WHERE l.room.id = :roomId " +
	           "AND l.checkOutDate >= :checkInDate " +
	           "AND l.checkInDate <= :checkOutDate")
	    int countBookingsForRoomWithinDateRange(@Param("roomId") Long roomId,
	                                            @Param("checkInDate") LocalDate checkInDate,
	                                            @Param("checkOutDate") LocalDate checkOutDate);
	 
	    boolean existsByPetAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(Pet pet, LocalDate checkOutDate, LocalDate checkInDate);

}
