/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *  
 */
package com.mThree.UI;

import java.time.LocalDate;

/*
 * this class contains all the stuff to do anything to be implemented else where in ui
 * in some respects its it's own "validation class" that is easier
 * where i like to validate user input to prevent shenanigans that break code
 *  since here it has a seemingly fully covered use case to pass all types of values
 *  i think we're probably not going to get exceptions due to passing bad types
 *  
 */
public interface UserIO {
	/*
	 * just going to comment in the descriptions from notes and learning
	 */

	// Print a given String to the console. The String value displayed should be
	// passed in as a parameter.
	void print(String message);

	/*
	 * Display a given message String to prompt the user to enter in a String, then
	 * read in the user response as a String and return that value. The prompt
	 * message should be passed in as a parameter and the String value read in
	 * should be the return value of the method.
	 */
	String readString(String prompt);

	/*
	 * Display a given message String to prompt the user to enter in an integer,
	 * then read in the user response and return that integer value. The prompt
	 * message value should be passed in as a parameter and the value that is read
	 * in should be the return of the method. Display a prompt to the user to enter
	 * an integer between a specified min and max range, and read in an integer. If
	 * the user's number does not fall within the range, keep prompting the user for
	 * new input until it does. The prompt message and the min and max values should
	 * be passed in as parameters. The value read in from the console should be the
	 * return of the method.
	 */
	int readInt(String prompt);

	int readInt(String prompt, int min, int max);

	/*
	 * Display a given message String to prompt the user to enter in a double, then
	 * read in the user response and return that double value. The prompt message
	 * value should be passed in as a parameter and the value that is read in should
	 * be the return of the method. Display a prompt to the user to enter a double
	 * between a specified min and max range, and read in a double. If the user's
	 * number does not fall within the range, keep prompting the user for new input
	 * until it does. The prompt message and min and max values should be passed in
	 * as parameters. The value read in from the console should be the return of the
	 * method.
	 */
	double readDouble(String prompt);

	double readDouble(String prompt, double min, double max);

	/*
	 * Display a given message String to prompt the user to enter a float and then
	 * read in the user response and return that float value. The prompt message
	 * value should be passed in as a parameter and the value that is read in should
	 * be the return of the method. Display a prompt to the user to enter a float
	 * between a specified min and max range, and read in a float. If the user's
	 * number does not fall within the range, keep prompting the user for new input
	 * until it does. The prompt message and min and max values should be passed in
	 * as parameters. The value read in from the console should be the return of the
	 * method.
	 */
	float readFloat(String prompt);

	float readFloat(String prompt, float min, float max);

	/*
	 * Display a given message String to prompt the user to enter in a long, then
	 * read in the user response and return that long value. The prompt message
	 * value should be passed in as a parameter and the value that is read in should
	 * be the return of the method. Display a prompt to the user to enter a long
	 * between a specified min and max range, and read in a long. If the user's
	 * number does not fall within the range, keep prompting the user for new input
	 * until it does. The prompt message and min and max values should be passed in
	 * as parameters. The value read in from the console should be the return of the
	 * method.
	 */
	long readLong(String prompt);

	long readLong(String prompt, long min, long max);

	// done and dusted... BUT somethings missing? no?
	// so what kinds of data will i take form the user?
	// what kinds of data would i pass to a database?
	// REMEMBER: dvd data transfer object should have fields:
	// title, release date, mpaa rating, director's name, studio, and user rating or
	// note (text box/comment)
	// so we got, string, string/date/number, string/number, string, string, and
	// string
	// thus we need a date

	LocalDate readDate(String prompt);

}
