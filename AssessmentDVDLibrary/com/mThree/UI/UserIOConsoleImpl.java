/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *  this one does the scanner and implements the userIO
 */
package com.mThree.UI;

//imports date since the userIo has date and scanner cause we need that and datetimeException
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

	/*
	 * so this is an implementation THUS we need all methods from UserIO to override
	 * 
	 */

	// we need a scanner, thus that first

	final private Scanner console = new Scanner(System.in);

	// some flavor text from the code along as well
	/**
	 *
	 * A very simple method that takes in a message to display on the console and
	 * then waits for a integer answer from the user to return.
	 *
	 * @param msg - String of information to display to the user.
	 *
	 */
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	/**
	 *
	 * A simple method that takes in a message to display on the console, and then
	 * waits for an answer from the user to return.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as string
	 */
	@Override
	public String readString(String msgPrompt) {
		System.out.println(msgPrompt);
		return console.nextLine();
	}

//just copying the stuff from the code along and its a code along
	/**
	 *
	 * A simple method that takes in a message to display on the console, and
	 * continually reprompts the user with that message until they enter an integer
	 * to be returned as the answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as integer
	 */
	@Override
	public int readInt(String msgPrompt) {
		boolean invalidInput = true;
		int num = 0;
		while (invalidInput) {
			try {
				// print the message msgPrompt (ex: asking for the # of cats!)
				String stringValue = this.readString(msgPrompt);
				// Get the input line, and try and parse
				num = Integer.parseInt(stringValue); // if it's 'bob' it'll break
				invalidInput = false; // or you can use 'break;'
			} catch (NumberFormatException e) {
				// If it explodes, it'll go here and do this. THIS FLAVOR TEXT! MOAR!
				// TODO the error messages should have more pizzaz.
				this.print("Input error. Please try again.");
			}
		}
		return num;
	}

	/**
	 *
	 * A slightly more complex method that takes in a message to display on the
	 * console, and continually reprompts the user with that message until they
	 * enter an integer within the specified min/max range to be returned as the
	 * answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @param min       - minimum acceptable value for return
	 * @param max       - maximum acceptable value for return
	 * @return an integer value as an answer to the message prompt within the
	 *         min/max range
	 */
	@Override
	public int readInt(String msgPrompt, int min, int max) {
		/*
		 * do u know what this is?! this is a validation class that is streamlined! i
		 * love it. i'm going to use this FOREVERYTHING basically the previous one we
		 * check if its an int... if its a mistake it just says "try again" and then
		 * this one now is now take int and check if in range of whatever I desire. last
		 * time i did this i did a bunch of if elses... this is so much cleaner. Sorcery
		 * i say!
		 */
		int result;
		do {
			result = readInt(msgPrompt);
		} while (result < min || result > max);

		return result;
	}

	/**
	 *
	 * A simple method that takes in a message to display on the console, and
	 * continually reprompts the user with that message until they enter a long to
	 * be returned as the answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as long
	 */
	@Override
	public long readLong(String msgPrompt) {
		while (true) {
			try {
				return Long.parseLong(this.readString(msgPrompt));
			} catch (NumberFormatException e) {
				this.print("Input error. Please try again.");
			}
		}
	}

	/**
	 * A slightly more complex method that takes in a message to display on the
	 * console, and continually reprompts the user with that message until they
	 * enter a double within the specified min/max range to be returned as the
	 * answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @param min       - minimum acceptable value for return
	 * @param max       - maximum acceptable value for return
	 * @return an long value as an answer to the message prompt within the min/max
	 *         range
	 */
	@Override
	public long readLong(String msgPrompt, long min, long max) {
		long result;
		do {
			result = readLong(msgPrompt);
		} while (result < min || result > max);

		return result;
	}

	/**
	 *
	 * A simple method that takes in a message to display on the console, and
	 * continually reprompts the user with that message until they enter a float to
	 * be returned as the answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as float
	 */
	@Override
	public float readFloat(String msgPrompt) {
		while (true) {
			try {
				return Float.parseFloat(this.readString(msgPrompt));
			} catch (NumberFormatException e) {
				this.print("Input error. Please try again.");
			}
		}
	}

	/**
	 *
	 * A slightly more complex method that takes in a message to display on the
	 * console, and continually reprompts the user with that message until they
	 * enter a float within the specified min/max range to be returned as the answer
	 * to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @param min       - minimum acceptable value for return
	 * @param max       - maximum acceptable value for return
	 * @return an float value as an answer to the message prompt within the min/max
	 *         range
	 */
	@Override
	public float readFloat(String msgPrompt, float min, float max) {
		float result;
		do {
			result = readFloat(msgPrompt);
		} while (result < min || result > max);

		return result;
	}

	/**
	 *
	 * A simple method that takes in a message to display on the console, and
	 * continually reprompts the user with that message until they enter a double to
	 * be returned as the answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as double
	 */
	@Override
	public double readDouble(String msgPrompt) {
		while (true) {
			try {
				return Double.parseDouble(this.readString(msgPrompt));
			} catch (NumberFormatException e) {
				this.print("Input error. Please try again.");
			}
		}
	}

	/**
	 *
	 * A slightly more complex method that takes in a message to display on the
	 * console, and continually reprompts the user with that message until they
	 * enter a double within the specified min/max range to be returned as the
	 * answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @param min       - minimum acceptable value for return
	 * @param max       - maximum acceptable value for return
	 * @return an double value as an answer to the message prompt within the min/max
	 *         range
	 */
	@Override
	public double readDouble(String msgPrompt, double min, double max) {
		double result;
		do {
			result = readDouble(msgPrompt);
		} while (result < min || result > max);
		return result;
	}
	/*
	 * now that the premade stuff that is amazing code is done lets follow the
	 * school's standard and construct a method for date
	 * 
	 */
	/**
	 *
	 * A simple method that takes in a message to display on the console, and
	 * continually reprompts the user with that message until they enter a valid date
	 * to be returned as the answer to that message.
	 *
	 * @param msgPrompt - String explaining what information you want from the user.
	 * @return the answer to the message as LocalDate
	 */
	@Override
	public LocalDate readDate(String prompt) {
		LocalDate date = null; // instantiating a localdate the thing that will be returned
		boolean validInput = true; // same for a boolean
		do {
			try {
				String stringValue = this.readString(prompt);
				date = LocalDate.parse(stringValue);// if bad format it throws exception
				// standard format is yyyy-mm-day
				// i can reformat it using dateTimeFormatter and then calling on a passed date
				// with [formatterObj].format()
				// format can be changed to a series of patterns as per java library docs
				// if no exception then we need to break the loop
				validInput = true; // making sure to change it if we get an error
			} catch (DateTimeException e) {
				this.print("Input error. Date is not in the correct format.\nPlease Try again.");
				validInput = false;
			}

		} while (!validInput);
		return date;
	}

}
