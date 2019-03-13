package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.model.Numbers;

public class NumbersController {
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	public Double add(Double first, Double second, Double third) {
		Double result = first + second + third;
		model.setResult(result);
		return model.getResult();
	}
	
	public double multiply(Double first, Double second) {
		Double result = first * second;
		model.setResult(result);
		return model.getResult();
	}
}

