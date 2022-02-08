package com.sg.foundations.variables;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniMadLibs {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		List<String> inputs = new ArrayList<String>();
		
	System.out.println("Let's play MAD LIBS!\n");
	
	System.out.println("I need a noun: ");
	inputs.add(inputReader.nextLine());	
	System.out.println("Now an adjective: ");
	inputs.add(inputReader.nextLine());
	System.out.println("Another noun: ");
	inputs.add(inputReader.nextLine());
	System.out.println("And a number: ");
	inputs.add(inputReader.nextLine());
	System.out.println("Another adjective: ");
	inputs.add(inputReader.nextLine());
	System.out.println("A plural noun: ");
	inputs.add(inputReader.nextLine());
	System.out.println("Another one: ");
	inputs.add(inputReader.nextLine());
	System.out.println("One more: ");
	inputs.add(inputReader.nextLine());
	System.out.println("A verb (infinitive form): ");
	inputs.add(inputReader.nextLine());
	System.out.println("Same verb (past participle): ");
	inputs.add(inputReader.nextLine());

	System.out.println("*** NOW LETS GET MAD (libs) ***");
	
	System.out.println(inputs.get(0)+": the "+inputs.get(1)+" frontier. These are the voyages of the" 
	+"starship "+inputs.get(3)+". Its "+inputs.get(4)+"-year mission: to explore strange" 
	+inputs.get(5)+ " " +inputs.get(6)+", to seek out "+inputs.get(5)+" "+inputs.get(7) 
	+" and "+inputs.get(5)
	+" " +inputs.get(8)+ ", to boldly "+inputs.get(9)+" where no one has "+inputs.get(10)+" before.");
	
}}
