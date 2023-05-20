package com.example.demo;


import jakarta.persistence.*;


@Entity
public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String type;
    private int capacity;
    private String disponibility;
    private String price;

    
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
	public String getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(String disponibility) {
		this.disponibility = disponibility;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", type=" + type + ", capacity=" + capacity
				+ ", disponibility=" + disponibility + ", price=" + price + "]";
	}

	
	
}
    
    
