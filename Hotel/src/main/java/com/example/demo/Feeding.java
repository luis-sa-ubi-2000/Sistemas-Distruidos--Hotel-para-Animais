package com.example.demo;

import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "feeding")
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name = "type_of_food")
    private String typeFood;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    // Other attributes, constructors, getters, and setters

    // Default constructor
    public Feeding() {
    }

    // Constructor
    public Feeding(String typeFood, Pet pet) {
        this.typeFood = typeFood;
        this.pet = pet;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(String typeFood) {
		this.typeFood = typeFood;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
    
    

    // Getters and Setters
    // ...
}
