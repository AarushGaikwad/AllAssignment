package com.app.fruits;

public class Fruit {
	String color;
	double weight;
	String name;
	boolean isFresh = true;
	
	public Fruit(String color, double weight, String name) {
		this.color = color;
		this.weight = weight;
		this.name = name;
	}
	
	public boolean isFresh() {
		return isFresh;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name: " + name + " color: " + color + " weight: " + weight;
	}
	
	public String taste() {
		return "no specific taste";
	}
	
	
}
