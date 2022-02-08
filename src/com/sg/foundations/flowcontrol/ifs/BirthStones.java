package com.sg.foundations.flowcontrol.ifs;

import java.util.*;

public class BirthStones {
	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        int x= 0;
        int y= 0;
       
        String month = null, stone = null;
        
       
       
        Boolean sentinal=false;
       
        System.out.println("What month's birthstone do you want to know? ");
        do {
        	sentinal=false;
            System.out.println("Enter your birth month as a 2 digit number?");
            
            try{ 
            	y =Integer.parseInt(inputReader.nextLine());
            	if(y>12) {
            		System.out.println("Nice try, but that's not a month!/nPlease try again.");
            		sentinal=true;
            		}
            	if(y<1) {
            		System.out.println("Nice try, but that's not a month!/nPlease try again.");
            		sentinal=true;
            	}
            	}
            
            catch (NumberFormatException e){
            	 System.out.println("That's not a number, Please try again!");
            	 sentinal=true;
            	}
            }while(sentinal);
        
        
        switch(y) {
        case 1:
        	month="January";
        	stone="Garnet";
        	break;
        case 2:
        	month="February";
        	stone="Amethyst";
        	break;
        case 3:
        	month="March";
        	stone="Aquamarine";
        	break;
        case 4:
        	month="April";
        	stone="Diamond";
        	break;
        case 5:
        	month="May";
        	stone="Emerald";
        	break;
        case 6:
        	month="June";
        	stone="Pearl";
        	break;
        case 7:
        	month="July";
        	stone="Ruby";
        	break;
        case 8:
        	month="August";
        	stone="Peridot";
        case 9:
        	month="September";
        	stone="Sapphire";
        	break;
        case 10:
        	month="October";
        	stone="Opal";
        	break;
        case 11:
        	month="November";
        	stone="Topaz";
        	break;
        case 12:
        	month="December";
        	stone="Turquoise";
        	break;
        	
        }
        System.out.println(month+"\'s birthstone is "+stone+".");
	}

}
