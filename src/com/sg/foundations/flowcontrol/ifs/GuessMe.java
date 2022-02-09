package com.sg.foundations.flowcontrol.ifs;

import java.util.*;


public class GuessMe {
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        final int x= 8;
        int y= 0;
        int i=0;
        
       
       
        Boolean sentinal=false;
        
        System.out.println("I've chosen a number. Betcha can't guess it!");
        do {
        	sentinal=false;
            System.out.println("Enter a number to guess?");
            
            try{ 
            	y =Integer.parseInt(inputReader.nextLine());
            	}
            
            catch (NumberFormatException e){
            	 System.out.println("That's not a number, Please try again!");
            	 sentinal=true;
            	}
            }while(sentinal);
        
        System.out.println("Your guess: "+y);
        System.out.print(y+"? ");
        if(y<x){i=0;} else if(y>x){i=1;} else {i=2;}
        switch(i) {
        case 0:
        	System.out.println( "Ha, nice try - too low! I chose #.");
        	break;
        case 1:
        	System.out.println("Too bad, way too high. I chose #.");
        	break;
        case 2:
        	System.out.println("Too bad, way too high. I chose #.");
        	break;
        
        	
        }
        
        inputReader.close();
	}}
