package com.gourmet.test;

import org.junit.Test;

import com.gourmet.game.HandleGame;

public class HandleGameAssertTest {

	@Test
	public void testStartGame() {
		HandleGame handle = new HandleGame();
		handle.startGame();
	}

}
