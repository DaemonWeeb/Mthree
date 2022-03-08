package com.mThree.helloworld;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class STREEEMZForDocumentation {
	public static void main(String[] args) {
		final Scanner userInput = new Scanner(System.in);
	    // create a list of integers
	    List<Integer> number = Arrays.asList(2,3,4,5);
	  
	    // demonstration of map method
	    List<Integer> square = number.stream().map(x -> x*x).
	                           collect(Collectors.toList());
	    System.out.println("#1: "+ square);
	  
	    // create a list of String
	    List<String> names =
	                Arrays.asList("Reflection","Collection","Stream", "stream");
	  final List<String> LETTERS = IntStream //a stream method for Int based parameter in this case its "c"
				.rangeClosed('A', 'Z')//rangedClosed method allows inclusive range here we're going A-Z
				.mapToObj(c -> "" + (char) c)//mapToObj method which returns an object-valued stream (garbly gook its forEach but allows me to mutate data into something else) 
				.collect(Collectors.toList());
	    System.out.println(LETTERS); 
	    
	    // demonstration of filter method
	    String z= userInput.nextLine();
	    String result = LETTERS.stream().filter(s->s.equalsIgnoreCase(z)).
	                          collect(Collectors.joining());
	    System.out.println(result);
	  
	    // demonstration of sorted method
	    List<String> show =
	            names.stream().sorted().collect(Collectors.toList());
	    System.out.println(show);
	  
	    // create a list of integers
	    List<Integer> numbers = Arrays.asList(2,3,4,5,2);
	  
	    // collect method returns a set
	    //sets don't have dupes nor order
	    Set<Integer> squareSet =
	         numbers.stream().map(x->x*x).
	         collect(Collectors.toSet());
	    System.out.println(squareSet);
	  
	    // demonstration of forEach method
	    number.stream().map(x->x*x).forEach(y->System.out.println(y));
	  
	    // demonstration of reduce method
	    int even =
	       number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	  
	    System.out.println(even);
	    
	    
	    
	    
	    
	   userInput.close(); 	
	}
}
