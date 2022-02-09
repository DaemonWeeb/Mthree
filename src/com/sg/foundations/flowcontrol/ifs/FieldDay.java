package com.sg.foundations.flowcontrol.ifs;
import java.util.*;
public class FieldDay {
	 public static void main(String[] args) {
	Scanner inputReader = new Scanner(System.in);
	@SuppressWarnings("unused")
	String userInput=null,team,nameString;
	int i;
	
	/*
	 * for this i need to do is check if its before Baggins,
	 */
	System.out.println("What is your last name? ");
	userInput =inputReader.nextLine();
	for(i=0;i<userInput.length();i++) {
		//so we need to check frist character to deterime if before b,D,h,p,v or after
		/*
		 * so we have somthing if(a or --> baggins)--> red dragons
		 * then if(baggint -->dresden)-->dark wiz
		 * then if(dresdeo -->howl)-->moving
		 * then if(howm -->potter)-->gold
		 * then if(pottes -->vimes)-->night
		 *  then if(vimet -->)-->blcak
		 *  this is hard to do and too much time to do. i'm skipping
		 */
		
		inputReader.close();}
	

}}
