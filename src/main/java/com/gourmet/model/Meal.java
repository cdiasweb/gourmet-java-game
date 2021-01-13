package com.gourmet.model;

public class Meal  {
		
	public Meal(String name, MealType type) {
		this.setName(name);
		this.setType(type);
		this.setSubtype(subtype);
	}
	
	public Meal(String name, MealType type, MealSubtype subtype) {
		this.setName(name);
		this.setType(type);
		this.setSubtype(subtype);
	}
	
	private String name;
	private MealType type;
	private MealSubtype subtype;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}
	
	public MealSubtype getSubtype() {
		return subtype;
	}

	public void setSubtype(MealSubtype subtype) {
		this.subtype = subtype;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
}
