package com.gourmet.model;

import java.util.ArrayList;

public class MealType {
		
	public MealType(String type) {
		this.setDescription(type);
	}
	
	private String description;
	private ArrayList<MealSubtype> subtypes = new ArrayList<MealSubtype>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String type) {
		this.description = type;
	}
	
	public void addSubtype(MealSubtype subtype) {
		this.subtypes.add(subtype);
	}

	public ArrayList<MealSubtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(ArrayList<MealSubtype> subtypes) {
		this.subtypes = subtypes;
	}
	
	
	
}
