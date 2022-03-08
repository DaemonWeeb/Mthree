/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/3/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   UserIo is an interface that can be implemented by any class to interact with user
 *   it just interacts with the user, but doesn't really have any logic
 *   it will be implemented console implementation
 *   while the ViewFromUpsideDown uses implementation not the interface to interact with the user, but is unaware of the implementation
 *   this is for encapsulation
 */
package com.mThree.UI;

public interface UserIo {
	/*
	 * what do i want the user interface to do? obviously read a string input and
	 * only not accept more than 1 letter print messages that i want out to the user
	 * print some ascci i am pretty sure a stream outputs a double and a long in
	 * some instances with possible parameters so set them up and prepare to Reactor
	 * there's probably some ints actually definitely since i'm using random right?
	 * yeah its for menu selection stuff
	 * 
	 * 
	 */
	/**
	 * A method that I can use to just print something without returning the
	 * carriage so here I can call this method to well print something to the user.
	 * and i can override it... so i could override it to idk... print "to the DRINK
	 * WITH YA!" stylized or import ... well i thought it was called "wrapper class"
	 * but wrapper class refers to strings and such. the class function i remember
	 * is opens another window and can draw stuff it can actually do a lot. i can
	 * even animate it. the point i'm making is this is the blank canvas that which
	 * i shall return something to the user (in console in this case).
	 * 
	 * 
	 * @param something a string that is passed to be printed when overridden
	 * 
	 */
	void printSomething(String something);

	/**
	 * as stated in the comment this is just a respond to a string. now as of time
	 * of commenting: This has only one param... I know I will need some custom
	 * logic so I have 2 options... override or overload.. and to be fair i might
	 * need the 1 param method.
	 * 
	 * Going to use this to capture user input and do logic with it. can be used for
	 * marshelling, unmarshelling, etc the implementation limitless.
	 * 
	 * @param something takes in a string,probably made by the user
	 * @return string returns a string in response probably made by different class
	 *         logic.
	 */
	String readString(String something);

	/**
	 * and overload of the previous method cause i know i need 1 letter and not
	 * multiples but i'm using streams so this might not be necessary. idk safety
	 * first if one is wondering why its !<1 and !>1 for the other 2 parameters?
	 * well its cause i plan to use the stream method to return length of the string
	 * either way method either returns an int or double or a long or something. so
	 * i can just "parse int" it or plan ahead
	 * 
	 * The point of the method is to mainly do validation on a string input from
	 * user
	 * changed the parameter to boolean
	 * 
	 * @param something
	 * @param sentinal boolean for validation
	 * 
	 * @return depends on implementation
	 */
	String readString(String something, boolean sentinal);

	/**
	 * Going to be honest, i don't think i need this method. At time of writing I
	 * just don't see myself ever accepting 1 int that i'm not validating from the
	 * user I'm not collecting a date, i'm not collecting time, nor large numbers
	 * the int will be for menu navigation so i'm never going to use this. but the
	 * point of this is be passed an int and perform logic on said int-- probably
	 * validation. changed the method to take in a string from the view to print out and 
	 * then collect the user int 
	 * 
	 * @param userPrompt
	 * @return depends on implementation
	 */
	int readInt(String userPromt);

	/**
	 * This method will primarily be used to control the menus and user selections
	 * for navigation. the passed string is the message to the user from view implementation
	 * and then the other parameters are the min and max for allowable selections
	 * 
	 * @param userPrompt
	 * @param min
	 * @param max
	 * @return depends on implementation
	 */
	int readInt(String userPromt, int min, int max);
	
	/**
	 * A method that I can use to just print something with returning the
	 * carriage so here I can call this method to well print something to the user.
	 * 
	 * 
	 * @param something a string that is passed to be printed when overridden
	 * 
	 */
	void printLnSomething(String something);
	
	//do a system.exit method?
	//its basically a method that takes a string and then prints it and then does system exit
	//so its println(); system.exit. it'll be present with a boolean or some int. 
	// so its overloaded printLnSomething()
	/**
	 * A method that I can use to just print something with returning the
	 * carriage so here I can call this method to well print something to the user, depending 
	 * if an int is passed as a parameter. its an overload.
	 * 
	 * 
	 * 
	 * @param something a string that is passed to be printed when overridden
	 * @param patienceCounter basically this will be used to pass the message of system Exit.
	 * 
	 */
	void printLnSomething(String something, int patienceCounter);
	
}
