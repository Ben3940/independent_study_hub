package edu.ycp.cs320.independent_study_hub.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class Numbers {
	private Double first, second, third, result;
	
	public Numbers() {
	}
	
	public void setFirst(Double first) {
		this.first = first;
	}
	
	public void setSecond(Double second) {
		this.second = second;
	}
	
	public void setThird(Double third) {
		this.third = third;
	}
	
	public void setResult(Double result) {
		this.result = result;
	}
	
	public Double getFirst() {
		return first;
	}
	
	public Double getSecond() {
		return second;
	}
	
	public Double getThird() {
		return third;
	}
	
	public Double getResult() {
		return result;
	}
	
}
