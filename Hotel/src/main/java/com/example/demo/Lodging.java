package com.example.demo;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    // Constructors, getters, and setters

    public Lodging() {
    }

    public Lodging(Pet pet, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.pet = pet;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Lodging [id=" + id + ", pet=" + pet + ", room=" + room + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + "]";
	}

    
	


    
    
}


