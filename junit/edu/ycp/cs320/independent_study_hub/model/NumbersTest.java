package edu.ycp.cs320.independent_study_hub.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Numbers;

public class NumbersTest {
	private Numbers model;
	
	@Before
	public void setUp() {
		model = new Numbers();
	}
	
	@Test
	public void testSetFirst() {
		model.setFirst(1.0);
		assertTrue(1.0 == model.getFirst());
	}
	
	@Test
	public void testSetSecond() {
		model.setSecond(2.0);
		assertTrue(2.0 == model.getSecond());
	}
	
	@Test
	public void testSetThird() {
		model.setThird(3.0);
		assertTrue(3.0 == model.getThird());
	}
}
