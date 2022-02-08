package com.sg.foundations.variables;

public class TheOrderOfThings {
	 public static void main(String[] args) {

	        double number;
	        String opinion, size, age, shape, color, origin, material, purpose;
	        String noun;
//doesn't work but its cannon for rick and morty nonsense
	        number = 5.0;
	        opinion = "Rick";
	        size = "Mortee";
	        age = "morty";
	        shape = "Morty";
	        color = "flurbo";
	        origin = "Goobar";
	        material = "gold";
	        purpose = "hot";

	        noun = "puppy";

	        // Using the + with strings doesn't add -- it concatenates! (sticks them together)
	        //could be reordered to make sense. 
	        //different concatenation
	        
	        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape
	                 + " " + color + " " + origin + " " + material + " " + purpose + " " + noun);
	    }
}
