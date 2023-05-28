package com.example.demo;

public class StatisticFood {
    private String specie;
    private String typeFood;
    
    
	public StatisticFood() {
		specie = "";
		typeFood = "";
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String gettypeFood() {
		return typeFood;
	}
	public void settypeFood(String typeFood) {
		this.typeFood = typeFood;
	}
	@Override
	public String toString() {
		return "StatisticFood [specie=" + specie + ", typeFood=" + typeFood + "]";
	}

    
}
