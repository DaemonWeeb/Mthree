/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   exception handling
 *   
 *  
 */

package com.mThree.DAO;

/*
 * interwebs said it was bad to make custom exception classes >_>
 * basically u only make them for exceptional situations
 * in salesforce, we make exceptions that are basially omni exception class
 * the point of that is so that the dev has a 1 class that is all exceptions to use for all scenarios and all lwc, aura, etc etc
 * its basically reusable but this-- this isn't reusable and its just extending the generic exception class 
 * i'm little confused to why it exists other than passing messages when an exception hits
 * 
 */
@SuppressWarnings("serial") // dunno anything about this legit new to me
public class DVDLibraryDAOException extends Exception {
	public DVDLibraryDAOException(String message) {
		super(message);
	}

	public DVDLibraryDAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
