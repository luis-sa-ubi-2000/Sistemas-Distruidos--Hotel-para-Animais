package com.example.demo;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String specie;
    
    private String race;

    public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Getters and Setters

    @Override
	public int hashCode() {
		return Objects.hash(age, client, id, name, race, specie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(client, other.client) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(race, other.race)
				&& Objects.equals(specie, other.specie);
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", species=" + specie + ", race=" + race
				+ ", client=" + client + "]";
	}

    
}
