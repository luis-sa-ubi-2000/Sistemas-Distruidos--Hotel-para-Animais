package com.example.demo;

public class StatisticSpecie {
    private String specie;
    private Long count;
    
    
	public StatisticSpecie() {
		specie = "";
		count = 0L;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "StatisticSpecie [specie=" + specie + ", count=" + count + "]";
	}

    
}
