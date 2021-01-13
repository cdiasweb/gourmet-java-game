package com.gourmet.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.gourmet.model.MealType;

public class MealTypeExceptionTest {

	@Test(expected = NullPointerException.class)
	public void testSetDescription() {
		MealType type = null;
		type.setDescription("descricao");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetSubtypes() {
		MealType type = new MealType("massa");
		String description = type.getSubtypes().get(0).getDescription();
		System.out.println(description);
	}

}
