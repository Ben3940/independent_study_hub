package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.controller.NumbersController;
import edu.ycp.cs320.independent_study_hub.model.Numbers;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
		
		controller.setModel(model);
		
		model.setFirst(1.0);
		model.setSecond(2.0);
		model.setThird(3.0);
	}
		
	@Test
	public void testAdd() {
		controller.add(1.0, 2.0, 3.0);
		assertTrue(6.0 == model.getResult());
		
		controller.add(-2.0, 2.0, 5.0);
		assertTrue(5.0 == model.getResult());
		
		controller.add(50.0, -30.0, 40.0);
		assertTrue(60.0 == model.getResult());
	}
	
	@Test
	public void testMultiply() {
		controller.multiply(2.0, 1.0);
		assertTrue(2.0 == model.getResult());
		
		controller.multiply(-4.0, -4.0);
		assertTrue(16.0 == model.getResult());
		
		controller.multiply(-10.0, 10.0);
		assertTrue(-100.0 == model.getResult());
	}
}
