package edu.ycp.cs320.independent_study_hub.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	
	@Test
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	
	@Test
	public void testGetGuess() {
		model.setMax(30);
		model.setMin(10);
		int guess = model.getGuess();
		assertEquals(20, guess);
	}
	
	@Test
	public void testSetIsLessThan() {
		model.setMax(50);
		model.setMin(20);
		model.setIsLessThan(model.getGuess());
		assertEquals(34, model.getMax());
	}
	
	@Test
	public void testSetIsGreaterThan() {
		model.setMax(50);
		model.setMin(20);
		model.setIsGreaterThan(model.getGuess());
		assertEquals(36, model.getMin());
	}
	
	@Test
	public void testIsDone() {
		model.setMax(20);
		model.setMin(20);
		assertTrue(model.isDone());
		
		model.setMax(30);
		model.setMin(15);
		assertFalse(model.isDone());
		
	}
}
