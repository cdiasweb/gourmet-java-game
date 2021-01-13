package com.gourmet.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gourmet.model.Meal;
import com.gourmet.model.MealSubtype;
import com.gourmet.model.MealType;

public class MealAssertTest {

	@Test
	public void testGetName() {
		MealType mealType = new MealType("massa");
		Meal meal = new Meal("lasanha", mealType);
		String name = meal.getName();
		assertEquals("lasanha", name);
	}

	@Test
	public void testSetName() {
		MealType mealType = new MealType("massa");
		Meal meal = new Meal("lasanha", mealType);
		meal.setName("pizza");
		assertEquals("pizza", meal.getName());
	}

	public void testGetType() {
		MealType mealType = new MealType("massa");
		Meal meal = new Meal("lasanha", mealType);
		MealType type = meal.getType();
		String description = type.getDescription();
		assertEquals("massa", description);
	}

	@Test
	public void testSetType() {
		MealType mealType = new MealType("massa");
		Meal meal = new Meal("lasanha", mealType);
		MealType type = meal.getType();
		String description = type.getDescription();
		assertEquals("massa", description);
	}

	@Test
	public void testGetSubtype() {
		MealType mealType = new MealType("massa");
		MealSubtype subtype = new MealSubtype("fofa");
		Meal meal = new Meal("lasanha", mealType);
		meal.setSubtype(subtype);
		String description = meal.getSubtype().getDescription();
		assertEquals("fofa", description);
	}

	@Test
	public void testSetSubtype() {
		MealType mealType = new MealType("massa");
		MealSubtype subtype = new MealSubtype("firme");
		Meal meal = new Meal("pizza", mealType);
		meal.setSubtype(subtype);
		String description = meal.getSubtype().getDescription();
		assertEquals("firme", description);
	}

}
