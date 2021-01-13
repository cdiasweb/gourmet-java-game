package com.gourmet.test;

import org.junit.Test;

import com.gourmet.model.Meal;
import com.gourmet.model.MealSubtype;
import com.gourmet.model.MealType;

public class MealExceptionTest {

	@Test(expected = NullPointerException.class)
	public void testGetType() {
		Meal meal = null;
		System.out.println(meal.getType());
	}

	@Test(expected = NullPointerException.class)
	public void testGetSubtype() {
		MealType mealType = new MealType("massa");
		MealSubtype subtype = new MealSubtype("fresca");
		mealType.addSubtype(subtype);
		Meal meal = new Meal("lasanha", mealType);
		System.out.println(meal.getSubtype().getDescription());
	}

}
