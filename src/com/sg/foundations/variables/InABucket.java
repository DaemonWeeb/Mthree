package com.sg.foundations.variables;

public class InABucket {
	 public static void main(String[] args) {

	        // You can declare all KINDS of variables.
	        String walrus;
	        double piesEaten;
	        float weightOfTeacupPig;//not used
	        int grainsOfSand;//not used

	        // But declaring them just sets up the space for data
	        // to use the variable, you have to put data IN it first!
	        walrus = "Sir Leroy Jenkins III";
	        piesEaten = 42.1;
	        weightOfTeacupPig = 68;
	        grainsOfSand = 34;
	        
	        System.out.println("Meet my pet walrus, " + walrus);
	        System.out.print("He was a bit hungry today and ate this many pies : ");
	        System.out.println(piesEaten);
	        System.out.println(grainsOfSand);
	        System.out.println(weightOfTeacupPig);
	    }
}
