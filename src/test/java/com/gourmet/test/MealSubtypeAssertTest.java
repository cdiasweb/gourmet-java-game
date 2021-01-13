package com.gourmet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gourmet.model.MealSubtype;

public class MealSubtypeAssertTest {

	@Test
	public void testMealSubtype() {
		MealSubtype subtype = new MealSubtype("massa");
		assertEquals("massa", subtype.getDescription());
	}

	@Test
	public void testGetDescription() {
		MealSubtype subtype = new MealSubtype("massa");
		assertEquals("massa", subtype.getDescription());
	}

	@Test
	public void testSetDescription() {
		MealSubtype subtype = new MealSubtype("massa");
		subtype.setDescription("fritas");
		assertEquals("fritas", subtype.getDescription());
	}

}
