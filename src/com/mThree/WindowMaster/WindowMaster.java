/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/7/22
 *  purpose: My first for this training Window Master program in an ide (eclipse)
 */
package com.mThree.WindowMaster;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*; //changed import to *

public class WindowMaster {

	public static void main (String[] args) {
		
		/*
		 * the plan:
		 * String variable for height (read from console)
			String variable for width (read from console)
			Float variable for height (converted from string; use float because we don't want to be limited to whole feet)
			Float variable for width (converted from string; use float because we don't want to be limited to whole feet)
			Float variable for area of window (calculated from height and width)
			Float variable for perimeter of window (calculated from height and width)
			Float variable for cost (calculated from area, perimeter, and costs)
		 */
		/**
		 * // declare variables for height and width
	    float height;
	    float width;
	     //declare strings
	    String stringHeight;
	    String stringWidth;
	    
	    
	   //declare other variables for math functions and what not
	    float areaOfWindow;
	    float cost;
	    float perimeterOfWindow;
	    //initialize scanner class
	    Scanner myScanner = new Scanner(System.in);
	    
	    //get the goods from user
	    System.out.println("Please enter window height in feet:");
	    stringHeight = myScanner.nextLine();
	    System.out.println("Please enter window width in feet:");
	    stringWidth = myScanner.nextLine();
	    
	    //conversion
	    height =Float.parseFloat(stringHeight);
	    width = Float.parseFloat(stringWidth);
	    
	    //maths
	    areaOfWindow = height*width;
	    perimeterOfWindow=2*(height+width);
	    cost= ((3.50f * areaOfWindow)+(perimeterOfWindow*2.25f)); 
	    
	    //outputs to use
	    System.out.println("Window height = " + stringHeight);
	    System.out.println("Window width = " + stringWidth);
	    System.out.println("Window area = " + areaOfWindow);
	    System.out.println("Window perimeter = " + perimeterOfWindow);
	    System.out.println("Total Cost =  " + cost);
	    
	     * supposed to reconfigure to accept multiple stuff and have try catch so the 
	     * simpler way is to do an array of user inputs followed by prompts and confirmations
	     *  
	     **/
		
		ArrayList<String> inputs= new 	ArrayList<String>();
		ArrayList<Float> numbers= new ArrayList<Float>();
	    
	    
	    //Initialize scanner
	    Scanner myScanner = new Scanner(System.in);
	    //ideally prompts come from a styleized text or etc and gathered in  loop.
	    // but that would go something like 
	    List<String> lines = Collections.emptyList();
	    try {
	      lines = Files.readAllLines(Paths.get("prompts.txt"), StandardCharsets.UTF_8);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    //2 escape sentinals
	    boolean sentinalOne= true;
	    boolean sentinalTwo=true;
	    int x= 1;//int for going thru stuff
	    String input;//
	    String input2;
	    do { //outer loop for whole program
	    	//inner loop switch
	    	switch(x) {
	    	case 1:
	    		do {
	    		try {	    			
	    			System.out.println(lines.get(0));
	    			input = myScanner.nextLine();
	    			input2= null;
	    			if(input != null && !input.isEmpty()) {
	    				System.out.println(lines.get(5)+input);
	    				input2 = myScanner.nextLine();
	    				if(input2.equalsIgnoreCase("y")){
	    					System.out.println(lines.get(6));
	    					x++;
	    					sentinalTwo=false;
	    					inputs.add(input);
	    					
	    				} else if(input2.equalsIgnoreCase("n")) {
	    					System.out.println(lines.get(7));
	    				}else {
	    					System.out.println(lines.get(7));
	    				}
	    				
	    			} else if(Float.parseFloat(input)<0) {
	    				System.out.println(lines.get(7));
	    			} else {System.out.println(lines.get(7));}
	    			
	    		}catch(NumberFormatException ex) {
	    			System.out.println(lines.get(7));
	    		}
	    		
	    	
	    		} while(sentinalTwo);
	    	case 2:
	    		do {
		    		try {
		    			sentinalTwo=true;
		    			input2= null;
		    			System.out.println(lines.get(1));
		    			input = myScanner.nextLine();
		    			if(input != null && !input.isEmpty()) {
		    				System.out.println(lines.get(5)+input);
		    				input2 = myScanner.nextLine();
		    				if(input2.equalsIgnoreCase("y")){
		    					System.out.println(lines.get(6));
		    					x++;
		    					inputs.add(input);
		    					sentinalTwo=false;
		    					
		    				} else if(input2.equalsIgnoreCase("n")) {
		    					System.out.println(lines.get(7));
		    				}else {
		    					System.out.println(lines.get(7));
		    				}
		    				
		    			} else if(Float.parseFloat(input)<0) {
		    				System.out.println(lines.get(7));
		    			} else {System.out.println(lines.get(7));}
		    			
		    		}catch(NumberFormatException ex) {
		    			System.out.println(lines.get(7));
		    		}
		    		
		    	
		    		} while(sentinalTwo);
	    	case 3:
	    		do {
		    		try {
		    			sentinalTwo=true;
		    			input2= null;
		    			System.out.println(lines.get(2));
		    			input = myScanner.nextLine();
		    			if(input != null && !input.isEmpty()) {
		    				System.out.println(lines.get(5)+input);
		    				input2 = myScanner.nextLine();
		    				if(input2.equalsIgnoreCase("y")){
		    					System.out.println(lines.get(6));
		    					x++;
		    					inputs.add(input);
		    					sentinalTwo=false;
		    					
		    				} else if(input2.equalsIgnoreCase("n")) {
		    					System.out.println(lines.get(7));
		    				}else {
		    					System.out.println(lines.get(7));
		    				}
		    				
		    			} else if(Float.parseFloat(input)<0) {
		    				System.out.println(lines.get(7));
		    			} else {System.out.println(lines.get(7));}
		    			
		    		}catch(NumberFormatException ex) {
		    			System.out.println(lines.get(7));
		    		}
		    		
		    	
		    		} while(sentinalTwo);
	    	case 4:
	    		do {
		    		try {
		    			sentinalTwo=true;
		    			input2= null;
		    			System.out.println(lines.get(3));
		    			input = myScanner.nextLine();
		    			if(input != null && !input.isEmpty()) {
		    				System.out.println(lines.get(5)+input);
		    				input2 = myScanner.nextLine();
		    				if(input2.equalsIgnoreCase("y")){
		    					System.out.println(lines.get(6));
		    					x++;
		    					inputs.add(input);
		    					sentinalTwo=false;
		    					
		    				} else if(input2.equalsIgnoreCase("n")) {
		    					System.out.println(lines.get(7));
		    				}else {
		    					System.out.println(lines.get(7));
		    				}
		    				
		    			} else if(Float.parseFloat(input)<0) {
		    				System.out.println(lines.get(7));
		    			} else {System.out.println(lines.get(7));}
		    			
		    		}catch(NumberFormatException ex) {
		    			System.out.println(lines.get(7));
		    		}
		    		
		    	
		    		} while(sentinalTwo);
	    	case 5:
	    		do {
		    		try {
		    			sentinalTwo=true;
		    			input2= null;
		    			System.out.println(lines.get(4));
		    			input = myScanner.nextLine();
		    			if(input != null && !input.isEmpty()) {
		    				System.out.println(lines.get(5)+input);
		    				input2 = myScanner.nextLine();
		    				if(input2.equalsIgnoreCase("y")){
		    					System.out.println(lines.get(6));
		    					x++;
		    					inputs.add(input);
		    					sentinalTwo=false;
		    					sentinalOne = false;
		    					
		    				} else if(input2.equalsIgnoreCase("n")) {
		    					System.out.println(lines.get(7));
		    				}else {
		    					System.out.println(lines.get(7));
		    				}
		    				
		    			} else if(Float.parseFloat(input)<0) {
		    				System.out.println(lines.get(7));
		    			} else {System.out.println(lines.get(7));}
		    			
		    		}catch(NumberFormatException ex) {
		    			System.out.println(lines.get(7));
		    		}
		    		
		    	
		    		} while(sentinalTwo);
	    	
	    }
		
	    
	}while(sentinalOne);
	    
	    	//now the maths
	    
	    float h = Float.parseFloat(inputs.get(0));
	    float w= Float.parseFloat(inputs.get(1));
	    float n= Float.parseFloat(inputs.get(2));
	    float cGlass= Float.parseFloat(inputs.get(3));
	    float cTrim = Float.parseFloat(inputs.get(4));
	    float areaOfWindow;
	    float cost;
	    float perimeterOfWindow;
	    areaOfWindow = h*w;
	    perimeterOfWindow=2*(h+w);
	    cost= n*((cGlass * areaOfWindow)+(perimeterOfWindow*cTrim)); 
	    
	    System.out.println(lines.get(8) + h);
	    System.out.println(lines.get(9) + w);
	    System.out.println(lines.get(10) + n);
	    System.out.println(lines.get(11) + areaOfWindow);
	    System.out.println(lines.get(12)+ perimeterOfWindow);
	    System.out.println(lines.get(13) + cost);
	    //results in an error due to build path for text
	}
	}
	


