package com.example.demo;

public class StatisticFood {
    private String TypeFood;
    private Long petCount;

    public String getTypeFood() {
        return TypeFood;
    }

    public void setTypeFood(String TypeFood) {
        this.TypeFood = TypeFood;
    }

    public Long getPetCount() {
        return petCount;
    }

    public void setPetCount(Long petCount) {
        this.petCount = petCount;
    }
	@Override
	public String toString() {
		return "StatisticSpecie [TypeFood=" + TypeFood + ", petCount=" + petCount + "]";
	}
}

