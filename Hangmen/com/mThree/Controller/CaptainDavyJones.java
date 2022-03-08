/**
 *  @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/1/22
 *  purpose: major project (eclipse), to make a hangman APP and show off oop and MVC design
 *  
 *  naming... Well the controller does all the lifting and is the mastermind. the conductor... the pirate captain so to speak. 
 *  The captain is the brains, the master, the overviewer, the one who watches and decides your fate. 
 *  
 */
package com.mThree.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mThree.DAO.ManifestOfTheFlyingDutchman;
import com.mThree.DAO.ReleaseTheKrakenException;
import com.mThree.DTO.WhatDoesItMeanToBeAWord;
import com.mThree.UI.ViewFormUpsideDown;

public class CaptainDavyJones {

	private ViewFormUpsideDown spyGlass;
	private ManifestOfTheFlyingDutchman captainsOrders;

	public CaptainDavyJones(ManifestOfTheFlyingDutchman dao, ViewFormUpsideDown view) {
		this.captainsOrders = dao;
		this.spyGlass = view;
	}

	/**
	 * the run method that starts the show off. it loops as along thins are valid.
	 */
	public void run() {
		boolean sentinal = true;
		int menuSelection = 0;
		try {
			while (sentinal) {

				// using the menuSelection getter
				menuSelection = spyGlass.printTodaysMenuAndTakeOrder();

				switch (menuSelection) {
				case 1:
					walkThePlank();
					break; // fun fact Idk why but i keep forgetting to add break :D
				case 2:
					anyLastWords();
					break;
				case 3:
					sentinal = false;
					break;
				default:
					hereThereBeMonsters();
				}

			}
			toTheDrink();
		} catch (ReleaseTheKrakenException e) {
			spyGlass.displayRunAGround(e.getMessage());
		}
	}

	private void walkThePlank() throws ReleaseTheKrakenException {
		// so they selected the hang man game first should be a confirmation of choice
		spyGlass.displayLetTheGameBegin();
		// now that its been confirmed we need promt them for difficulty choice
		boolean sentinal = true;
		int menuSelection = 0;
		try {
			while (sentinal) {

				menuSelection = spyGlass.getDifficultySelection();

				// whichDifficulty(menuSelection);
				selectedDifficulty(menuSelection);
				
				sentinal =false; //TODO running out of time ot implement the retry clause

			}

		} catch (ReleaseTheKrakenException e) {
			spyGlass.displayRunAGround(e.getMessage());
		}

	}

	private void selectedDifficulty(int difficulty) throws ReleaseTheKrakenException {

		switch (difficulty) {
		case 1:

			whichDifficulty("Easy");
			break;
		case 2:

			whichDifficulty("Medium");
			break;
		case 3:

			whichDifficulty("Hard");
			break;
		}
		

	}

	private void whichDifficulty(String difficulty) throws ReleaseTheKrakenException {

		String difficultyLevel = difficulty;
		String fatedWord = captainsOrders.getWordByDifficulty(difficultyLevel);
		List<String> userGuesses = new ArrayList<String>();
		List<String> wordAsList = fatedWord.chars().mapToObj(s -> (char) s).map(s -> s.toString())
				.collect(Collectors.toList());
		List<String> spaces = wordAsList.stream().map(s -> " _ ").collect(Collectors.toList());
		boolean loseLife = true;

		// wordAsList.stream().filter(s-> wordAsList.get(x)==userGuesses.get(x) ?
		// spaces.set(x, userGuesses.get(x)) : x++ );
		while (!(wordAsList.containsAll(spaces))) {
			int x = 0;
			boolean test = userGuesses.get(x).equalsIgnoreCase(wordAsList.get(x));
			userGuesses.add(spyGlass.getUserGuess(loseLife));
			spyGlass.displaySpaces(spaces);
			spyGlass.displayUserGuessesSoFar(userGuesses, (7-x));
			if (test) {
				spaces.set(x, userGuesses.get(x));
				loseLife = false;
			} else if (wordAsList.containsAll(spaces)) {
				spyGlass.displayWin();
				break;
			} else if (loseLife) {
				x++;
			} else if (x > 7) {
				gameOver(fatedWord);
				break;
			}

		}

	}

	private void anyLastWords() throws ReleaseTheKrakenException {
		WhatDoesItMeanToBeAWord word = spyGlass.addNewWordPrompt();
		captainsOrders.addWurd(word.getStringValue(), word);
		spyGlass.displaySuccess(word.getStringValue());

	}

	private void hereThereBeMonsters() {
		spyGlass.hereThereBeMonsters();
	}

	private void toTheDrink() {
		spyGlass.displayExitBanter();
	}

	private void gameOver(String word) throws ReleaseTheKrakenException {
		spyGlass.displayLose();
		captainsOrders.removeWerd(word);
	}

}