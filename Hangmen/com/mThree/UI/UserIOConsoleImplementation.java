/**
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/4/22
 * purpose: major project (eclipse), to make a hangman APP and show off oop and MVC design
 * the UserIoConsole handles all the user inputs and then does somehting with it
 * 
 * so we're going to comment EVERYTHING OUT and redo it as lambda's one thing that is to be noted... 
 * I don't know if this will work. we have the interface userio... and this is its implementation...
 * Technically i can just do lambdas within the view file... But... for simplcitiy we'll do it here
 *  
 */

/*
 * quick aside... I know now that all lambdas are methods and all methods can be a lambda. I've ONLY ever used a lambda as a short hand for list loop stuff
 * so i've never EVER thought to use a method as a lambda or lambdas as methods
 * the question i just suddenly had was "why wouldn't i just make everything a lambda and vice versa." 
 * Truthfully, i knew the answer already BEFORE looking it up. How i know it probably from past education on the matter, but I instinctively said
 * "cause lambdas aren't reusable code" basically a lambda isn't a declared method thus can't be reused... but lambdas are also harder to read.
 * First lets make it the way it was "done via MVC" then we'll go from there. 
 */
package com.mThree.UI;


import java.util.Scanner;


public class UserIOConsoleImplementation implements UserIo {

	/*
	 * since this covers all the user input and interactions we need a scanner
	 * 
	 */
	final private String EXITMESSAGE1 = "I've given you many tries to get this right! You've exceeded my patience! TO THE DEPTHS OF THE LOCKER WITH YOU!";
	final private String INVALIDMSG = "Are you trying my patience? Now make a proper selection!";
	final private Scanner userInput = new Scanner(System.in); // scanner doesn't need to change nor be available outside
																// it's class

	/*
	 * final private List<String> LETTERS = IntStream // a stream method for Int
	 * based parameter in this case its "c" .rangeClosed('A', 'Z') // rangedClosed
	 * method allows inclusive range here we're going A-Z .mapToObj(c -> "" +
	 * (char)* c)// mapToObj method which returns an object-valued stream (jargon,
	 * but its essentially forEach but allows me to mutate data into something else)
	 * .collect(Collectors.toList()); // this is the collect method that calls on
	 * the collector class to do the toList method, returns a list<String> of our
	 * letters
	 * 
	 *
	 * 
	 */
	/*
	 * above stream just does exactly what one expects, its a loop that
	 * increments c and casts it as a letter inclusive a-z and adds them as an array
	 * these are all standard out of box methods inside the stream class. update: i
	 * commented it out cause eclipse was giving me a "final warning" something
	 * about streams. and it was above my head way above my head. i searched for a
	 * solution found a better way of doing this anyways. i'm not sure what the
	 * issue is.
	 */

	/*
	 * so few things... This whole class is not necessary. if we're doing lambdas. i
	 * could just use a lambdas to implement Everything
	 */

	/**
	 * A method to print something that is passed to it. I have it as print vs
	 * printLn which I know will bite me in the butt, but I want this for just print
	 * function... i do need a println function too... so i can either add in the
	 * return carriages as needed... change it to println make another method for
	 * both functions. OR overload this one with some secondary parameter I'm going
	 * to opt for the printLn method save myself some work.
	 * 
	 * @param something a string that is passed
	 * 
	 */
	@Override
	public void printSomething(String something) {
		System.out.print(something);
	}

	/**
	 * A method to print something that is passed to it on a new line.
	 * 
	 * @param something a string that is passed
	 * 
	 */
	@Override
	public void printLnSomething(String something) {
		System.out.println(something);
	}

	/**
	 * A method to get user input. the go to method for this project. mostly menu
	 * selections, inputing letters, inputing a word its used for user input and
	 * passed some prompt that will be used to tell what to enter from user. will
	 * return the scanner input
	 * 
	 * @param something a message to the user to input something
	 * @return userInput that is a string next line input
	 * 
	 */
	@Override
	public String readString(String something) {
		printLnSomething(something);
		return userInput.nextLine();

	}

	/**
	 * we'll come back to this cause I has some ideas so this one is interesting we
	 * need it to do 2 things 1 it needs to be just 1 letter. it also needs be
	 * compared to something in the the alphabet
	 */
	@Override
	public String readString(String something, boolean sentinal) {
		int attempts = 0;
		String userSelection;
		do {
			userSelection = readString(something);
			sentinal = userSelection.chars() // retuns an intStream which is a stream of numbers and rets the string as
												// characters
					.allMatch(// boolean method to test if all parameters match
							Character::isLetter);// here are the parameters a Character and a Letter.
			// the double colon is a streamlined version of lambda's
			/*
			 * the double colon turns (Object x,Object y)-> {logic} to
			 * Logic.method(Object::Method) this only works methods in streams So in this
			 * case (double colons are new me) we have Character object and using the
			 * isLetter method but checking that everything matches from streams after
			 * converting input to characters streams are super powerful theres too many
			 * methods
			 */

			// result = LETTERS.stream().filter(s->s.equalsIgnoreCase(userSelection)).
			// collect(Collectors.joining());
			// code commented out cause it doesn't work produces a final warning in eclipse
			// too above my knowledge gap to get working. the code in testing works.
			// in order to gt it working, i need to pass the userSelection to a final
			// variable
			// then do more logic on then pass the variable to something not final and do
			// logic on it.
			// like checking if the input is between just 1 character, since we know its a
			// letter now.

			attempts++;
			if (attempts > 3) {
				printLnSomething(EXITMESSAGE1, attempts);
			} 
			
			
		} while (!sentinal);

		return userSelection;
	}

	/**
	 * so the point of this method is to get a userinput and parse as an int. that's
	 * all its going to be used for. its not going to be used for logic, but rather
	 * just validation. the secondary overloaded method below will do more
	 * validation and return the userSelection
	 * 
	 * @param userPromt
	 * @return userSelection for furhter processing
	 */
	@Override
	public int readInt(String userPromt) {
		int userSelection = 0; // instantiating a return of the user input as int
		boolean valid = true; // sentinal for looping
		int x = 0; // counter for attempts on validation, after 3 its game over i'd say
		while (valid) { // while loop for looping user input until valid
			if (x > 3) {
				this.printLnSomething(EXITMESSAGE1, x); // exiting console after 3 invalid attempts
			}
			/*
			 * one second: so the x>3 can be written as a lambda. i could do boolean ?
			 * Parameter test
			 */
			try {
				String userInput = this.readString(userPromt); // recall readSTr passes our prompt, but returns a
																// scanner in
				// now parse that to int
				userSelection = Integer.parseInt(userInput);
				valid = false;
				x = 0;

			} catch (NumberFormatException e) {
				this.printLnSomething(INVALIDMSG);
				x++;
			}
		}
		return userSelection;
	}

	/**
	 * a method to loop thru user inputs in a menu selection screen within
	 * parameters of min and max basically we have 3 options~ the user can take and
	 * they're numbered if they hit something wrong... well then its to the drink
	 * 
	 * @param userPromt
	 * @param min
	 * @param max
	 */
	@Override
	public int readInt(String userPromt, int min, int max) {
		int attempts = 0;
		int userSelection = 0;
		do {
			userSelection = readInt(userPromt);
			attempts++;
			if (attempts > 3) {
				printLnSomething(EXITMESSAGE1, attempts);
			}
		} while (userSelection < min || userSelection > max);
		return userSelection;
	}

	/**
	 * A method to do the printLnSomething but this time all it does is exit the
	 * console. same method double parameters
	 * 
	 * @param something
	 * @param patienceCounter
	 */
	@Override
	public void printLnSomething(String something, int patienceCounter) {
		printLnSomething(something);
		System.exit(patienceCounter % patienceCounter);// cheeky 0
		
		
	}

}
