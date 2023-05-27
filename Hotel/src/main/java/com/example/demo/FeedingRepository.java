package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Feeding;

//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository
//CRUD refers Create, Read, Update, Delete

public interface FeedingRepository extends CrudRepository<Feeding, Long>{

}
