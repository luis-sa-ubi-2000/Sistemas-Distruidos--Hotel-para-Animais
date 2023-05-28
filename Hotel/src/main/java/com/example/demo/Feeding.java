package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

    @Column(name = "type_food")
    private String typeFood;

    // Constructors, getters, and setters

    public Feeding() {
    }

    public Feeding(Pet pet, Room room, String typeFood) {
        this.pet = pet;
        this.typeFood = typeFood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    @Override
    public String toString() {
        return "Feeding [id=" + id + ", pet=" + pet + ", typeFood=" + typeFood + "]";
    }
}

