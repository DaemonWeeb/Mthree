package com.sg.foundations.scanner;
import java.util.*;

public class QuestForTheUserInput {
	 public static void main(String[] args) {
	        Scanner inputReader = new Scanner(System.in);

	        String yourName;
	        String yourQuest;
	        double velocityOfSwallow=0;
	       
	        Boolean sentinal=false;

	        // We can use the Scanner's readLine to assign value to our strings
	        // because its return type is string
	        System.out.println("What is your name?? ");
	        yourName = inputReader.nextLine();

	        System.out.println("What is your quest?! ");
	        yourQuest = inputReader.nextLine();

	        // When we get to our double data type, we can use Scanner's nextDouble method
	        // or we can use the Double.parseDouble to convert the nextLine's String
	        
	        //do-while catch loop
	        do {
	        System.out.println("What is the airspeed velocity of an unladen swallow?!?! ");
	        sentinal=false;
	        try{ velocityOfSwallow = Double.parseDouble(inputReader.nextLine());
	        	}
	        catch (NumberFormatException e){
	        	 System.out.println("Entered in a non-number, Please try again!");
	        	 sentinal=true;
	        	
	        }}while(sentinal);
	        
	        
	        System.out.println();
	        System.out.println("How do you know " + velocityOfSwallow + " is correct, " + yourName + "?");
	        System.out.println("You didn't even know if the swallow was African or European!");
	        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest + ".");
	    }
}
