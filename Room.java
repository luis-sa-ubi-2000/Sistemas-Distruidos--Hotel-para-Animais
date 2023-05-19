package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Room {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String type;
    private int capacity;
    private boolean disponibility;
    private double price;

    public Room(int numero, String tipo, int capacidade, boolean disponibility, double price) {
        this.number = numero;
        this.type = tipo;
        this.capacity = capacidade;
        this.disponibility = disponibility;
        this.price = price;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean getDisponibility() {
    	return disponibility;
    }
    
    public void setDisponibility(boolean disponibility) {
    	this.disponibility = disponibility;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    // toString method

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + id +
                ", Number='" + number + '\'' +
                ",Tipology=" + type +
                ", Capacity='" + capacity + '\'' +
                ", Disponibility='" + disponibility + '\'' +
                ", Price=" + price +
                '}';
    }
}
