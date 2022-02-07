/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/7/22
 *  purpose: My first for this training Window Master program in an ide (eclipse)
 */
package com.mThree.WindowMaster;

import java.util.Scanner;

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
		// declare variables for height and width
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
	}
	}
	


