package com.sg.foundations.scanner;

import java.util.Scanner;

public class PassingTheTuringTest {
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String nom, color, fruit;
        int x=8;
        final int favoriteNumber=-7;
        final String favoriteColor= "Black";
        final String nomeDePlume= "Sister of the Abyss Walkers, Marie Lothaar";
        final String favoriteFruit= "Human Heartfruit of Sorrows";
        Boolean sentinal=false;
        
        //name stuff
        System.out.println("Greetings and fair tidings.");
        System.out.println("What pray tell is your name?? ");
        nom = inputReader.nextLine();
        System.out.println(nom+"?? How curious! I go by "+nomeDePlume+".");
        
        //color stuff
        
        System.out.println("What is your favorite color? ");
        color = inputReader.nextLine();
        
        System.out.println(color+"?? Most intriguing. My favorite color is "+favoriteColor+", for it is all I have ever known...");

        //fruit stuff
        
        System.out.println("Forgive my rudeness. What is thy favorite fruit?");
        fruit = inputReader.nextLine();
        
        System.out.println(fruit+"?? Very tasty indeed. Mine is "+favoriteFruit+"...");
        System.out.println("I know it sounds terrifying, but trust me, it soothes the soul.");
        
        
        //number stuff
        System.out.println("Do you believe in fortune numbers; What number fo you believe holds luck?");
                
        //do-while catch loop
        do {
        
        sentinal=false;
        try{ x = Integer.parseInt(inputReader.nextLine());
        	}
        catch (NumberFormatException e){
        	 System.out.println("That's no number! Please, waht is your lucky number?!");
        	 sentinal=true;
        	
        }}while(sentinal);
        
        
        System.out.println();
        System.out.println(x+"? I see... Mine is "+favoriteNumber+"...");
        System.out.println("Well if you add "+ x +" + "+favoriteNumber+" you get "+ (x+favoriteNumber) +".");
        System.out.println("That must hold some luck, no?");
        
    }
}
