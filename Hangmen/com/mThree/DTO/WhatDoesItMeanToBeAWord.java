/**
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/3/22
 * purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 * This is the data transfer object. basically it what helps model the object and transfer data between stuff
 * huh... they mean data not "data" in DTA. as in u have an thing that = x and now that x can be moved to the view or moved to the file storage
 * or it can be "present" thus the controller brings up y function. i thought it meant data as in bytes or computer jargon :P
 * 
 * the class says its all, what does it mean to be a word? and i have no idea we know it has few properties discussed below
 * 
 * 
 */
package com.mThree.DTO;

public class WhatDoesItMeanToBeAWord {
	/*
	 * [TODO] they're going to ask u what is a geter/setter vs constructor etc cause esoteric. add that
	 * properties for the sake of the game well it has letters that are a "word" so
	 * lets say "stringValue" (i think thats a OOB method so lets google that
	 * nomenclature before committing to it) it has a length which 1) we don't need
	 * to know but 2) desperately need to know at all times. and that sounds
	 * confusing, so let me explain. see i know i have options to take a string and
	 * convert to letters and count its length etc etc at anything during runtime.
	 * so why would I store this value? cause we need it at all times for function.
	 * so why not just call the length function and store it as a variable? well i
	 * "could do that" but I need to store the "difficulty" of word based on length.
	 * so it's easier to store its length AND difficulty
	 * 
	 * okay used eclipse to auto setup getters and setters... but i'm thinking at
	 * the moment. what is the "read only" key. so if u set a word it auto generates
	 * a length that is read only and its difficulty thus is also auto generated.
	 * thinking of commenting out the setters. here's my reasoning we need all of
	 * these fields to be read only. the "key" item is the word itself. its unique
	 * and case insensitive and its other important data are formulas and derived
	 * from the word in salesforce the Object Word__c would have field text value...
	 * and then 2 other formula fields that are derived. so in whatever layout or
	 * automation/programming i'd enter in a new word and it'd populate the other 2
	 * fields. but the name itself is being used as the key field instead of an auto
	 * number id. so its also read only. I hope it works though XD
	 *
	 */

	private String stringValue;
	private String difficulty;
	private int length;

	/*
	 * setters which i'm not going to be using cuase I want read only. now I was
	 * going to do logic here, but that's not one does with a getter/setter so lets
	 * say i make a word... i enter in the name and do x= "nom"->x.setName(x); so
	 * now the name is set, what i should do after is x.setLength(x.length());
	 * instead of logic in the setter and the same goes for x.setDiff(x.ratingOf());
	 * which would return a string based on its getLentgh. or something along those
	 * lines.
	 */
//	public void setDifficulty(String difficulty) {
//		this.difficulty = difficulty;
//	}
//
//	public void setStringValue(String stringValue) {
//		this.stringValue = stringValue;
//	}
//
//	public void setLength(int length) {
//		this.length = length;
//	}

	/*
	 * getters for the things I think I need. they just
	 */

	public String getStringValue() {
		return stringValue;
	}

	public int getLength() {
		return length;
	}

	public String getDifficulty() {
		return difficulty;
	}

	/*
	 * the actual setter i'm going to be using that are read only.
	 */
	/**
	 * A combined method that "sets"(its not a setter its a constructor) read-only
	 * the 3 variables i need to keep track of
	 * 
	 * @param stringValue -- a passed and validated user input
	 * @param length      -- a derived value based on passed user input
	 * @param difficulty  -- a derived value based on derived length
	 */
	public WhatDoesItMeanToBeAWord(String stringValue, int length, String difficulty) {
		this.stringValue = stringValue;
		this.length = length;
		this.difficulty = difficulty;
	}

}
