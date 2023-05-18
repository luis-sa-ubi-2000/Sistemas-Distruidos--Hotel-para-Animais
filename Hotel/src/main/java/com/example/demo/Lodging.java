

import jakarta.persistence.*;

@Entity
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "idRoom")
    private Room room;

    // Constructors, getters and setters

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

	@Override
	public String toString() {
		return "Lodging [id=" + id + ", pet=" + pet + ", room=" + room + "]";
	}
    
    
}

