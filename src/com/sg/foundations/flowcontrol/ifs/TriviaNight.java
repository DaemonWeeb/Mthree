package com.sg.foundations.flowcontrol.ifs;

import java.util.*;

public class TriviaNight { 
	public static void main(String[] args) {

    Scanner inputReader = new Scanner(System.in);
    String userInput=null;
    Boolean sentinal=false;
    
    System.out.println("It's TRIVIA NIGHT! Are you ready?!");
    System.out.println("FIRST QUESTION!");
    
    do {
    	System.out.println("What is my Cat's name?");
    	System.out.print("A) Nero\t");System.out.println("B) CJ");
    	System.out.print("C) Bob\t");System.out.println("D) Yeezee");
        sentinal=false;
        try{ userInput = inputReader.nextLine();
        	if(!(userInput.equalsIgnoreCase("a"))
        			&&!(userInput.equalsIgnoreCase("b"))
        			&&!(userInput.equalsIgnoreCase("c"))
        			&&!(userInput.equalsIgnoreCase("d"))) {
        	System.out.println("Sorry, not an acceptable answer. Please try again.");
        	 sentinal=true;
        	}}
        catch (NumberFormatException e){
        	 System.out.println("Error, Please try again!");
        	 sentinal=true;
        	
        }}while(sentinal);
    if(userInput.equalsIgnoreCase("a")) {
    		System.out.println("Correct!");}
    else {System.out.println("incorrect!");}
    
    do {
    	System.out.println("What is my favorite food?");
    	System.out.print("A) Banana \t");System.out.println("B) Onions");
    	System.out.print("C) Pizza \t");System.out.println("D) Gum");
        sentinal=false;
        try{ userInput = inputReader.nextLine();
        	if(!(userInput.equalsIgnoreCase("a"))
        			&&!(userInput.equalsIgnoreCase("b"))
        			&&!(userInput.equalsIgnoreCase("c"))
        			&&!(userInput.equalsIgnoreCase("d"))) {
        	System.out.println("Sorry, not an acceptable answer. Please try again.");
        	 sentinal=true;
        	}}
        catch (NumberFormatException e){
        	 System.out.println("Error, Please try again!");
        	 sentinal=true;
        	
        }}while(sentinal);
    if(userInput.equalsIgnoreCase("c")) {
    		System.out.println("Correct!");}
    else {System.out.println("incorrect!");}
    do {
    	System.out.println("What is my favorite game?");
    	System.out.print("A) Hon\t");System.out.println("B) BloodBorne");
    	System.out.print("C) Hots\t");System.out.println("D) Lol");
        sentinal=false;
        try{ userInput = inputReader.nextLine();
        	if(!(userInput.equalsIgnoreCase("a"))
        			&&!(userInput.equalsIgnoreCase("b"))
        			&&!(userInput.equalsIgnoreCase("c"))
        			&&!(userInput.equalsIgnoreCase("d"))) {
        	System.out.println("Sorry, not an acceptable answer. Please try again.");
        	 sentinal=true;
        	}}
        catch (NumberFormatException e){
        	 System.out.println("Error, Please try again!");
        	 sentinal=true;
        	
        }}while(sentinal);
    if(userInput.equalsIgnoreCase("b")) {
    		System.out.println("Correct!");}
    else {System.out.println("incorrect!");}
    
    


    inputReader.close();}}
