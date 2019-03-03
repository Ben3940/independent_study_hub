package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.controller.GuessingGameController;
import edu.ycp.cs320.independent_study_hub.model.GuessingGame;

public class GuessingGameControllerTest {
	private GuessingGame model;
	private GuessingGameController controller;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
		controller = new GuessingGameController();
		
		model.setMin(1);
		model.setMax(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testStartGame() {
		controller.startGame();
		int max = model.getMax();
		int min = model.getMin();
		
		assertEquals(100, max);
		assertEquals(1, min);
	}
	
	@Test
	public void testNumberIsGreater() {
		int currentGuess = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertTrue(model.getGuess() > currentGuess);
		
		int currentGuess2 = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertFalse(model.getGuess() < currentGuess2);
	}
	
	@Test
	public void testNumberIsLess() {
		int currentGuess = model.getGuess();
		controller.setNumberIsLessThanGuess();
		assertTrue(model.getGuess() < currentGuess);
	}
	
	@Test
	public void testSetNumberFound() {
		int currentGuess = model.getGuess();
		controller.setNumberFound();
		assertTrue(model.getGuess() == currentGuess);
	}
}
