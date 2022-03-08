package com.mThree.UI;

import java.util.List;

import com.mThree.DTO.WhatDoesItMeanToBeAWord;

public class ViewFormUpsideDown {

	private UserIo io;

	public ViewFormUpsideDown(UserIo io) {
		this.io = io;
	}

	public void displayRunAGround(String message) {
		io.printLnSomething("We've seem to have hit something!" + message);

	}

	public int printTodaysMenuAndTakeOrder() {
		io.printLnSomething("Welecom abord the Ductchman!\n ...at least for now...");
		io.printLnSomething("1. Care to wager your life on walking the plank?");
		io.printLnSomething("2. Wanna add a fancy word to our repitoire?");
		io.printLnSomething("3. exit on the life Raft?");
		return io.readInt("Please select from the above choices", 1, 3);
	}

	public void displayLetTheGameBegin() {
		io.printLnSomething("Very Well then! The game be Hanged Man, but you walk the plank!");

	}

	public int getDifficultySelection() {
		io.printLnSomething("Pick a difficulty. It'll determine how hard yee word be.");
		io.printLnSomething("1. Easy?");
		io.printLnSomething("2. Medium?");
		io.printLnSomething("3. Kraken?");
		return io.readInt("Please select from the above choices.", 1, 3);
	}

	public String getUserGuess(boolean sentinal) {
		return io.readString("Guess your letter", sentinal);
	}

	public void displaySpaces(List<String> spaces) {
		spaces.stream().forEach(e -> io.printLnSomething(e));
		;

	}

	public void displayWin() {
		io.printLnSomething("Congrats you've won!");

	}

	public void displayLose() {
		io.printLnSomething("You've lost matey, time to walk the plank!");

	}

	public void displayUserGuessesSoFar(List<String> userGuesses, int x) {
		userGuesses.stream()
				.forEach(e -> io.printLnSomething("you've guessed so far: " + e + " with " + x + " lives remaining"));

	}

	public WhatDoesItMeanToBeAWord addNewWordPrompt() {
		String title = io.readString("Please give me a word");
		String difficulty = "";
		switch (title.length()) {
		case 1:

			difficulty = "Easy";
			break;
		case 2:

			difficulty = "Medium";
			break;
		case 3:

			difficulty = "Hard";
			break;
		}

		WhatDoesItMeanToBeAWord word = new WhatDoesItMeanToBeAWord(title, title.length(), difficulty);
		return word;
	}

	public void displaySuccess(String stringValue) {
		io.printLnSomething("Success a new word for the crew!");

	}

	public void hereThereBeMonsters() {
		io.printLnSomething("Here there BE MONSTERS!");

	}

	public void displayExitBanter() {
		io.printLnSomething("Let's play again sometime.");

	}

	

}
