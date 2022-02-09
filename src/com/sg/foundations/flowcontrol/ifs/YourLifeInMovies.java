package com.sg.foundations.flowcontrol.ifs;

import java.util.*;

public class YourLifeInMovies {
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        @SuppressWarnings("unused")
		final int x= 2006;
        int y= 0;
        int i=0;
        String nom;
        List <String> responses = new ArrayList<String>();
        responses.add("that Pixar's 'Up' came out over a decade ago.");
        responses.add("that the first Harry Potter came out over 15 years ago.");
        responses.add("that Space Jam came out not last decade, but the one before THAT.");
        responses.add("that the original Jurassic Park release is closer to the first lunar landing than it is to today.");
        responses.add("that the MASH TV series has been around for almost half a century!");
        
       
       
        Boolean sentinal=false;
        
        System.out.println("Hey, let's play a game! What's your name? ");
        nom=inputReader.nextLine();
        System.out.println("Ok, "+nom+" when were you born? ");        
        do {
        	sentinal=false;
            System.out.println("Enter a year?");
            
            try{ 
            	y =Integer.parseInt(inputReader.nextLine());
            	
            	if(y<0) {
            		System.out.println("That's not a valid year, Please try again!");
            		sentinal=true;
            		
            	} else if(y<1900){
            		System.out.println("You can't be that old... Please try again!");
            		sentinal=true;
            	}else if(y>2022) {
            		System.out.println("Stop being a meemer... Please try again!");
            		sentinal=true;
            	}            	
            	}
            
            catch (NumberFormatException e){
            	 System.out.println("That's not even a number, Please try again!");
            	 sentinal=true;
            	}
            }while(sentinal);
        
        System.out.println("Well "+nom+"... ");
        if(y>2005){System.out.println("Welp, I got nothing!");}
        else {
        	if(y<1965) {
        		i=4;
        	}
        	
        	else if(y<1975&&i!=4) {
        		i=3;
        	}
        	else if(y<1985&&i!=3) {
        		i=2;
        	}
        	else if(y<1995&&i!=2) {
        		i=1;
        	}
        	else if(y<2005&&i!=1) {
        		i=0;
        	}
        	System.out.print("Did you know ");
        for(int n=0;n<=i;n++) {
        	System.out.print(responses.get(n)+"\nAnd...");
        	if(n==i) {System.out.print(" that's all got!");
        	}}
        }
        
     inputReader.close();   
        
	}}
