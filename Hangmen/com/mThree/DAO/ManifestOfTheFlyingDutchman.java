/**
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/4/22
 * purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 * 
 * An interface that outlines the methods for the crew to implement. From the manifest, the crew takes stock, and does their work that must be done.
 * Maintain and man the Dutchmen or to Davy Jones' locker with the lot of you! 
 */
package com.mThree.DAO;

//import java.util.Map;

import com.mThree.DTO.WhatDoesItMeanToBeAWord;

public interface ManifestOfTheFlyingDutchman {
	/*
	 * one thing that is interesting is what do I need from this interface?
	 * well add word and remove word
	 * that's it. maybe some search methods.
	 * 
	 * there will need to be a method to get a word that is between a difficulty level
	 * and that method needs to then random between 0-ret.lenght() to pick 1 word.
	 * so think thats 2 methods
	 * one that maps word with difficulty 
	 * one that randoms between the returned list and picks one word.
	 * 
	 */
	/**
	 * A method to add a word to the storage layer. Will either add it and return null or return the duplicate if one is there is one present
	 * 
	 * @param word  a word that one wishes to be used for storage and identification. hopefully spelled right ;) 
	 * @param werd  that actual "word" object that is added which i named unnecessarily long for the purpose of code tracking for myself.
	 * @return either a null or WhatDoesItMeanToBeAWord object record
	 * @throws ReleaseTheKrakenException
	 */
	WhatDoesItMeanToBeAWord addWurd(String word, WhatDoesItMeanToBeAWord werd) throws ReleaseTheKrakenException; 
	
	/**
	 * A method that removes a word from the storage layer. Will either remove it and return something to be implemented or return null if none present
	 * 
	 * @param word
	 * @return implementation specific or null
	 * @throws ReleaseTheKrakenException
	 */
	WhatDoesItMeanToBeAWord removeWerd(String word) throws ReleaseTheKrakenException;
	
	/**
	 * hmmm... this might not work... A method to map difficulty to search for a word. the goal is to return 1 word psudo random of a given difficulty
	 * and by word i mean the word object. so i'm passing the difficulty and mapping it to the object... and it hopefully should return something in a collection
	 * and then from there it does some random shenanigans and ultimately return 1 word. 
	 * in apex i'd do a Soql query with the search parameters a bind variable of the difficulty and then return the list, from there i could limit by 1 record
	 * but in this case we want a "random" record which i'm not familiar with random in apex, but i know it exists. 
	 * but i'd probably loop thru and pull out one randomly
	 * 
	 * the premise is the same here. 
	 * 
	 * @param difficulty
	 * @return a single word object of a given difficulty at random. 
	 * @throws ReleaseTheKrakenException
	 */
	//Map<String, WhatDoesItMeanToBeAWord> getWordsByDifficulty(String difficulty) throws ReleaseTheKrakenException;
	/**
	 * Well if ur reading this u know why this is here... I only need to return 1 word by diffculty for the application
	 * thats 1 string.  so i got real silly with the map function. good method, totally useless otherwise.
	 * 
	 * @param difficulty
	 * @return
	 * @throws ReleaseTheKrakenException
	 */
	String getWordByDifficulty(String difficulty) throws ReleaseTheKrakenException;
}
