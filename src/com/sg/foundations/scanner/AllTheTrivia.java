package com.sg.foundations.scanner;
import java.util.*;
public class AllTheTrivia {
	 public static void main(String[] args) {
		 //using random
		 Random rand= new Random();
		 Scanner inputReader = new Scanner(System.in);
		 int upperBound=4;
		 List<String> answers= new ArrayList<String>();
		 System.out.println("Where is the deepest hole on earth?");
		 answers.add(inputReader.nextLine());
		 System.out.println("What is the tallest building on earth?");
		 answers.add(inputReader.nextLine());
		 System.out.println("What is the oldest structure on earth?");
		 answers.add(inputReader.nextLine());
		 System.out.println("Who is the President of the Us?");
		 answers.add(inputReader.nextLine());
		 
		 //random could do it so it also removes the input from the array list so it has no repeats
		 //to do that just store the rand and then remove the item in that position from the list
		 System.out.println(answers.get(rand.nextInt(upperBound))+" is the deepest hole on earth!");
		 System.out.println(answers.get(rand.nextInt(upperBound))+" is the tallest building on earth!");
		 System.out.println(answers.get(rand.nextInt(upperBound))+" is the oldest structure on earth!");
		 System.out.println(answers.get(rand.nextInt(upperBound))+" is the President of the Us!");
		 
		 inputReader.close();}
		 
}
