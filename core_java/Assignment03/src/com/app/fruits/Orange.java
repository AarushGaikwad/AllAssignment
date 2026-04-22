package com.app.fruits;

public class Orange extends Fruit{

	public Orange(String name, String color, double weight) {
		super(color, weight, name);
		
	}
	
	@Override
	public String taste() {
		return "sour";
	}

}
