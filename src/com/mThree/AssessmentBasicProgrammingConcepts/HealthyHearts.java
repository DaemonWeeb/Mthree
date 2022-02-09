package com.mThree.AssessmentBasicProgrammingConcepts;

import java.util.Scanner;

public class HealthyHearts {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		        
		        Double x= (double) 0;
		        Double y= (double) 0;
		        
		        
		       
		       
		        Boolean sentinal=false;
		        do {
		            System.out.println("What is your age? ");
		            sentinal=false;
		            try{ x = Double.parseDouble(inputReader.nextLine());
		            	}
		            catch (NumberFormatException e){
		            	 System.out.println("That's not a number, Please try again!");
		            	 sentinal=true;
		            	
		            }}while(sentinal);
		        y=220-x;
			 System.out.println("Your maximum heart rate should be "+y+" beats per minute.");
			 System.out.println("Your target heart rateis "+(0.5*y)+" - "+(0.85*y)+" beats per minute.");
			 inputReader.close();
}}
