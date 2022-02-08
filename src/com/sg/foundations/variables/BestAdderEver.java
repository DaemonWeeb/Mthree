package com.sg.foundations.variables;
import java.util.*;


public class BestAdderEver {
	 public static void main(String[] args) {
		 //using random
		 Random rand= new Random();
		 int x,y,z,upperBound;
		 upperBound=55;
		 x= rand.nextInt(upperBound);
		 y=rand.nextInt(upperBound);
		 z=rand.nextInt(upperBound);
		 System.out.println(x +"+"+ y +"+"+ z + "="+(x+y+z));
		 
		 
	 }
}
