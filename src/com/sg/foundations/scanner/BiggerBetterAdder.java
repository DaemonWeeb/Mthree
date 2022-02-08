package com.sg.foundations.scanner;

import java.util.Scanner;

public class BiggerBetterAdder {
	public static void main(String[] args) {
Scanner inputReader = new Scanner(System.in);
        
        Double x= (double) 0;
        Double y= (double) 0;
        Double z= (double) 0;
       
        Boolean sentinal=false;
        do {
            System.out.println("1st number? ");
            sentinal=false;
            try{ x = Double.parseDouble(inputReader.nextLine());
            	}
            catch (NumberFormatException e){
            	 System.out.println("That's not a number, Please try again!");
            	 sentinal=true;
            	
            }}while(sentinal);
        do {
            System.out.println("2nd number? ");
            sentinal=false;
            try{ y = Double.parseDouble(inputReader.nextLine());
            	}
            catch (NumberFormatException e){
            	 System.out.println("That's not a number, Please try again!");
            	 sentinal=true;
            	
            }}while(sentinal);
        do {
            System.out.println("3rd number? ");
            sentinal=false;
            try{ z = Double.parseDouble(inputReader.nextLine());
            	}
            catch (NumberFormatException e){
            	 System.out.println("That's not a number, Please try again!");
            	 sentinal=true;
            	
            }}while(sentinal);
	 System.out.println(x +"+"+ y +"+"+ z + "="+(x+y+z));
	 
	 
}

}
