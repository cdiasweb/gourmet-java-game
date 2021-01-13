package com.gourmet.test;

import org.junit.Test;

import com.gourmet.model.MealSubtype;

public class MealSubtypeExceptionTest {

	@Test(expected = NullPointerException.class)
	public void testSetDescription() {
		MealSubtype subtype = null;
		System.out.println(subtype.getDescription());
	}

}
