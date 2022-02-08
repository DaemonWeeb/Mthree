package com.sg.foundations.variables;

import java.util.Scanner;

public class DoItBetter {
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        Double x= (double) 0;
        Double y= (double) 0;
        Double z= (double) 0;
       
        Boolean sentinal=false;
	
	
	
	
	
	
	   //do-while catch loop
    do {
    System.out.println("How many miles can you run?");
    sentinal=false;
    try{ x = Double.parseDouble(inputReader.nextLine());
    	}
    catch (NumberFormatException e){
    	 System.out.println("That's not a number, Please try again!");
    	 sentinal=true;
    	
    }}while(sentinal);
    System.out.println("Oh yeah?! Well I can run "+ (++x)+" miles!");
  //do-while catch loop
    do {
    System.out.println("How many hotdogs can you eat?");
    sentinal=false;
    try{ y = Double.parseDouble(inputReader.nextLine());
    	}
    catch (NumberFormatException e){
    	 System.out.println("That's not a number, Please try again!");
    	 sentinal=true;
    	
    }}while(sentinal);
    System.out.println("Oh yeah?! Well I can eat "+ (++y)+" hotdogs!");
  //do-while catch loop
    do {
    System.out.println("How many languages do you know?");
    sentinal=false;
    try{ z = Double.parseDouble(inputReader.nextLine());
    	}
    catch (NumberFormatException e){
    	 System.out.println("That's not a number, Please try again!");
    	 sentinal=true;
    	
    }}while(sentinal);
    System.out.println("Oh yeah?! Well I know "+ (++z)+" languages!");
    	
}}
