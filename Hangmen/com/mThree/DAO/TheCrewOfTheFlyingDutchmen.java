/**
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/6/22
 * purpose: major project (eclipse), to make a hangman APP and show off oop and MVC design
 * point of this class is to be the main point of data access handles retrieving and storing data
 * 
 */
package com.mThree.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mThree.DTO.WhatDoesItMeanToBeAWord;

public class TheCrewOfTheFlyingDutchmen implements ManifestOfTheFlyingDutchman {

	private Map<String, WhatDoesItMeanToBeAWord> words = new HashMap<>();// map of string to word obj used to hold data
	private final String PIRATE_CODE;
	private final String DELIMITER = "::";

	public TheCrewOfTheFlyingDutchmen() {
		PIRATE_CODE = "words.txt";
	}

	@Override
	public WhatDoesItMeanToBeAWord addWurd(String word, WhatDoesItMeanToBeAWord werd) throws ReleaseTheKrakenException {
		loadTheShip();
		WhatDoesItMeanToBeAWord wurd = words.put(word, werd);
		captainsLog();

		return wurd;
	}

	@Override
	public WhatDoesItMeanToBeAWord removeWerd(String word) throws ReleaseTheKrakenException {
		loadTheShip();
		WhatDoesItMeanToBeAWord removeWord = words.remove(word);
		captainsLog();
		return removeWord;
	}

	@Override
	public String getWordByDifficulty(String difficulty) throws ReleaseTheKrakenException {
		/*
		 * so we have a map and we definatley need a map but when this function is
		 * called we just need 1 entity returned as a string wit that said we want it at
		 * random the map function is not ordered so there are no indexes so my preivous
		 * plan won't work Wait a tic brendan... we only need to return a string... we
		 * don't need to return an object. don't over complicate this stream the map
		 * into array of strings and then do random index of the array. dawg i spent an
		 * hour and i'm stupid... i need to use filter not forEach scratch that its .map
		 * :D
		 **/
		loadTheShip();// retrieve the data from the text file
		Map<String, WhatDoesItMeanToBeAWord> retWord = // so we're making a map of string to the object and in this case
														// mapping difficulty as a string to the object
				words.entrySet().stream() // here were using the map that was declared at start to store things and
											// entering the data into the map via a stream
						.filter(// using filter to go thru all data given a condition
								(WhatDoesItMeanToBeAWord) -> // setting in the lambda the object parameter that will be
																// worked on
								WhatDoesItMeanToBeAWord.getValue().getDifficulty().equalsIgnoreCase(difficulty)) // the
																													// logic
																													// of
																													// the
																													// filter
						// logic follows getting the value mapping and using DTO to return a word if it
						// equals the passed parameter of the method
						.collect(Collectors.toMap// finally collecting it as a map
						(Map.Entry::getKey, Map.Entry::getValue)); // using double colons to do the map methods to map
																	// difficulty (passed parameter) and returned object
																	// from filter

		// as stated before I need to turn map to list
		List<String> collectedWords = retWord.values().stream() // taking the mapped values passing as a stream to a
																// list
				.map((WhatDoesItMeanToBeAWord) -> WhatDoesItMeanToBeAWord.getStringValue())// the .map actually is a
																							// mutator function changing
																							// the Map to just a string
																							// of the word
				.collect(Collectors.toList());// collecting it as a list

		// WhatDoesItMeanToBeAWord->WhatDoesItMeanToBeAWord.getStringValue() ignore this
		// took forever to make the above list stream
		// now that I have the list STRING of the words just random index of it
		Collections.shuffle(collectedWords); // Collections class is nifty with this one.

		return collectedWords.get(0);// just returning the first word found in the list
		// LUL i get to here... and then the method is returning a map i'm
		// silly :P
	}
	/**
	 * A method to unmarshal a word. we split the string and create an object
	 * it should be noted i'm doing a parseInt method. now i was worried i might get a mismatch input
	 * but here its coming from the file... and garbage in, garbage out. and the garbage won't be collected in. 
	 * 
	 * @param word  
	 * @return
	 */
	private WhatDoesItMeanToBeAWord unmarshallWord(String word) {
		String[] wordToken = word.split(DELIMITER); // passed a string representing 1 line of the file using the
													// delimiter to pass into an array
		String werd = wordToken[0]; // the word
		String lenght = wordToken[1]; // its length
		String difficulty = wordToken[2]; // its corresponding difficulty
		WhatDoesItMeanToBeAWord wordFromTheBrineyDepths = new WhatDoesItMeanToBeAWord(werd, Integer.parseInt(lenght),
				difficulty); // might do an exception
		return wordFromTheBrineyDepths; // returning the word object

	}

	/**
	 * method to read all the words into the text file
	 * the while loop could be made into a stream/lambda-- i know it can't but lack time and skill at the moment to do so. 
	 * this creates a map that is used by words, thus allowing for usage to other layers of the applicaiton
	 * @throws ReleaseTheKrakenException
	 */
	private void loadTheShip() throws ReleaseTheKrakenException {
		Scanner hoistTheColors;
		try {
			hoistTheColors = new Scanner(new BufferedReader(new FileReader(PIRATE_CODE)));
		} catch (FileNotFoundException e) {
			throw new ReleaseTheKrakenException("There be no monsters here!", e);
		}
		// String word;
		WhatDoesItMeanToBeAWord wurd;
		while (hoistTheColors.hasNextLine()) {
			wurd = unmarshallWord(hoistTheColors.nextLine());
			words.put(wurd.getStringValue(), wurd);
		}
		hoistTheColors.close();

	}

	/**
	 * a method to do marshaling of a passed word object. it returns a string to be
	 * used by the file writer method
	 *
	 * @param word
	 * @return wordConstruct
	 */
	private String marshallWord(WhatDoesItMeanToBeAWord word) {
		String wordConstruct = word.getStringValue() + DELIMITER;
		wordConstruct += word.getLength() + DELIMITER;
		wordConstruct += word.getDifficulty();

		return wordConstruct;

	}

	/**
	 * method to write all the words into the text file way it works is better
	 * understood at by the words variable which collects the map of the <String,
	 * Object> pooled in it from here we use the methods to do file writing and some
	 * stream shenanigans marshal the object of the map and write to file
	 * 
	 * @throws ReleaseTheKrakenException
	 */
	private void captainsLog() throws ReleaseTheKrakenException {
		PrintWriter theBlackSpot;
		try {
			theBlackSpot = new PrintWriter(new FileWriter(PIRATE_CODE));
		} catch (IOException e) {
			throw new ReleaseTheKrakenException("It appears the sea has a rythmn of it's own.", e);
		}
		words.values().stream() // using the map to make a stream
				.map(WhatDoesItMeanToBeAWord -> marshallWord(WhatDoesItMeanToBeAWord))// changing the data to the object
																						// and passing thru marshalling
																						// process
				.forEach(// looping thru each string
						y -> {
							theBlackSpot.println(y);
							theBlackSpot.flush();
						}); // printing a line of the marshaled string and then writing to the storage file

		theBlackSpot.close();// closing resource

	}

}
