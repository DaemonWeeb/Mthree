/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/8/22
 *  purpose: major project (eclipse)
 */
package com.mThree.AssessmentBasicProgrammingConcepts;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
	/*
	 * this is actually kinda ez by comparison
	 * update 1: it says random 5 breeds? does that mean i have multiples greater than 5? upto 5?
	 * 
	 */
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random rand= new Random();
        String nom;//dog name 
        int x= 100; //used for max random and for percentage computations
        int a,b,c,d,e; //used for computations to make the percentages in decreasing amounts
        System.out.println("What is your dog's name?");
        nom=inputReader.nextLine();
        System.out.println("Well then, I have this highly "
        		+"reliable report on "+nom
        		+"'s prestigious background right here.");
        System.out.println(nom +" is:");
        a=rand.nextInt(x);
        b=rand.nextInt((x-a));
        c=rand.nextInt((x-a-b));
        d=rand.nextInt((x-a-b-c));
        e=(x-a-b-c-d);
        System.out.println(a +"% St. Bernard");
        System.out.println(b+ "% Chihuahua");
        System.out.println(c +"% Dramatic RedNosed Asian Pug");
        System.out.println(d +"% Common Cur");
        System.out.println(e +"% King Doberman");
	inputReader.close();}
}
