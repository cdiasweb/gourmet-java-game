package com.gourmet.model;

public class MealSubtype {
	
	public MealSubtype(String description) {
		this.setDescription(description);
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.getDescription();
	}
	
}
