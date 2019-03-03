package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.model.GuessingGame;

/**
 * Controller for the guessing game.
 */
public class GuessingGameController {
	private GuessingGame model;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	public void setModel(GuessingGame model) {
		this.model = model;
	}

	/**
	 * Start a new guessing game by setting the minimum to 1 and the maximum to 100.
	 */
	public void startGame() {
		model.setMin(1);
		model.setMax(100);
		//throw new UnsupportedOperationException("TODO - implement");
	}

	/**
	 * Called to indicate that the current guess is correct.
	 * Set the min and max to the current guess.
	 */
	public void setNumberFound() {
		int current_guess = model.getGuess();
		model.setMin(current_guess);
		model.setMax(current_guess);
		//throw new UnsupportedOperationException("TODO - implement");
	}

	/**
	 * Called to indicate that the user is thinking of a number that
	 * is less than the current guess.
	 */
	public void setNumberIsLessThanGuess() {
		int guess = model.getGuess();
		if (guess == 2 || guess == 1){
			model.setMax(1);;
			model.setMin(1);
			setNumberFound();
		} else {
			model.setIsLessThan(guess);
		//throw new UnsupportedOperationException("TODO - implement");
		}
	}

	/**
	 * Called to indicate that the user is thinking of a number that
	 * is greater than the current guess.
	 */
	public void setNumberIsGreaterThanGuess() {
		model.setIsGreaterThan(model.getGuess());
		//throw new UnsupportedOperationException("TODO - implement");
	}
}
