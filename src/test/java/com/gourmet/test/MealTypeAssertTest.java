package com.gourmet.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gourmet.model.MealSubtype;
import com.gourmet.model.MealType;

public class MealTypeAssertTest {

	@Test
	public void testMealType() {
		MealType type = new MealType("massa");
		assertEquals("massa", type.getDescription());
	}

	@Test
	public void testAddSubtype() {
		MealType type = new MealType("massa");
		MealSubtype subtype = new MealSubtype("macia");
		type.addSubtype(subtype);
		String description = type.getSubtypes().get(0).getDescription();
		assertEquals("macia", description);
	}

}
