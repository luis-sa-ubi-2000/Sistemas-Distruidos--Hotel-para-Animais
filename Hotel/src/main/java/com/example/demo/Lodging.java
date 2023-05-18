package com.example.demo;


import jakarta.persistence.*;

@Entity
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idPet")
    private Long idPet;

    @Column(name = "idRoom")
    private Long idRoom;

    // Construtores, getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

	@Override
	public String toString() {
		return "Lodging [id=" + id + ", idPet=" + idPet + ", idRoom=" + idRoom + "]";
	}
    
    
}
