package com.sg.foundations.scanner;
import java.util.*;
public class DontForgetToStoreIt {
	 public static void main(String[] args) {

	        int meaningOfLifeAndEverything = 42;
	        double pi = 3.14159;
	        String cheese, color;

	        Scanner inputReader = new Scanner(System.in);

	        System.out.println("Give me pi to at least 5 decimals: ");
	        pi=Double.parseDouble(inputReader.nextLine());

	        // We've used Double.parseDouble but meaningOfLifeAndEverything is an INT
	        // so we'll have to use Integer.parseInt

	        /*
	         * quick aside here...
	         * so these inputs down here all need massive validation 
	         * its easier and faster to make a custom exception class and validation method class 
	         * then call them here as needed in do-while try catch loops. 
	         * but that's lots of work for the time being and honestly beyond the scope of this one
	         * but it is good to note I both know how to do it and would do it 
	         * for now i'll just mark it as
	         * TODO: validation class, exception class, try-catch input loops.
	         * 
	         */
	        
	        System.out.println("What is the meaning of life, the universe & everything? ");
	        //this one needs complex validation and the parsing is kinda silly
	        //one can put in a string or anything for "the meaning of life"?
	        //so this should except strings and do a switch later on.
	        meaningOfLifeAndEverything=Integer.parseInt(inputReader.nextLine());

	        System.out.println("What is your favorite kind of cheese? ");
	        //this should have a full on validation checking known cheeses
	        //since its difficult to know every cheese in existance it should just throw an error 
	        //that is caught and delivers "Are you sure that's a cheese?"
	        //if this were apex or a component i'd do a picklist or multipicklist values
	        //keep the data cleaner
	        cheese=inputReader.nextLine();

	        System.out.println("Do you like the color red or blue more? ");
	        //like here should be an if() block to see if red or blue 
	        //or a validation method call in try-catch loop
	        color=inputReader.nextLine();

	        System.out.println("Ooh, " + color + "\n" + cheese +" sounds delicious!");
	        System.out.println("The circumference of life is " +( 2 * pi * meaningOfLifeAndEverything));
	        /*
	         * legit i don't like this assignment theres so much ToDo with the way they laid it out.
	         * it'd be 2-3 hours to fix it up
	         * if i got time i'll go back to this and fo all the notes i said
	         * -- but otherwise it remains as is for the throw away assingment
	         * 
	         */
}}

