/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/8/22
 *  purpose: major project (eclipse)
 */
package com.mThree.AssessmentBasicProgrammingConcepts;
import java.util.*;


public class RockPaperScissors {
	/*
	 * we're building a Rock paper scissors app that takes a user input
	 * so we need account for user error
	 * loops
	 * etc 
	 * simple
	 * so rock>scissors>paper>rock
	 * 
	 * additionally user gives number of rounds with max of 10 and min of 1
	 * so the assignment wants to me numerically represent the signs. (not what i'd do, but okay)
	 * comp does random and chooses a sigil and we go from there
	 * 3 out comes: tie, greater, lesser
	 * need to track wins and losses
	 * after rounds then we declare the winner and do flavoer text
	 * whole thing is in a loop? so it can do it again :/ that sucks cause 
	 * its better to do this as another class that calls this function--or another method ^^
	 * so we have main method that returns and loops the game
	 * a method that tracks wins and losses
	 * a method that retuns winner/loser
	 * a method for validation
	 * 
	 * 
	 * some stylization might happen later well see
	 */

	public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random rand= new Random();
        
		int playerChooice,numberOfRounds=0,numberOfWins = 0,
		numberOfLosses = 0, numberOfTies = 0, validationAttempts=0, comptuterRoll;
        int[] outputNumbers= {0,0,0};//arr for returned arr
        final int MAX_ATTEMPTS_VALIDATION=3;
        
        String playerInputDecision = null;//will accept yes, no, y, n, "null", 1, 2,--others throw error
        //change of plans used for all player input for hte most part
        //on error ask if try input again? up to 3 times, --then break
        
        
		Boolean sentinal=null,playerDecisionToPlay = true,validInput = null;
        //sentinal for breaking loops just setting if need be
        
        /*
         * so the whole thing needs to be in a  try,catch
         * then proceed to a loop IF they choosen correctly
         */
        System.out.println("\t     Hello New player!"); //could ask for name
        System.out.println("\tWould you care to play a game of\n\t   Rock, Paper, Scissors?");
        System.out.println("\t\t   1) Yes?\n\t\t   2) No?");
        while(playerDecisionToPlay){
        try {
        	playerInputDecision=inputReader.nextLine(); 
        	validInput=inputValidation(playerInputDecision);
        	if(validInput) {
        	System.out.println("Splendid! Just a moment...");
        	playerDecisionToPlay=true; //setting this for a while loop
        	} 
        	else {
        		System.out.println(playerInputDecision+"? "
        				+"that's not a yes, so this is unfortunate.\nPerhaps some other time...");
        		System.exit(0);
        	}
        	
        	
        }
        catch(Exception e){
        	System.out.println("You entered something weird!\n"+ e +"\nNow Terminating!");
        	System.exit(0);
        }
        
        /*
         * so player decided to play now we need them to choose number of rounds
         * since specifically I'm to terminate if they enter something out of min/max
         * then this isn't a loop
         */
        try {
        	System.out.println("How many rounds shall we play?");
        	System.out.println("\t1-10?");
        	numberOfRounds=Integer.parseInt(inputReader.nextLine()); 
        	validInput=inputValidation(numberOfRounds);
        	if(validInput) {
        	System.out.println(numberOfRounds+"? Wonderful! Prepare yourself for our game!");
        	playerDecisionToPlay=true; //setting this for a while loop
        	} 
        	else {
        		System.out.println(numberOfRounds+"? "
        				+"that's not within my parameters! Most unfortunate!\nPerhaps some other time...");
        		System.exit(0);
        	}
        	
        	
        }
        catch(Exception e){
        	System.out.println("You dare mock me with entering something weird!?\n"
        			+"How dare you!\nI say good to you!");
        	System.exit(0);
        }
        
        /*
         * now we have rounds we do a loop to call the function of rock paper scissors
         * so hours of banging my head and reconfigering code. couldn't figure out problems with 
         * switch statements...
         * its cause i forgot in java u need to put break; in each case :C
         * i feel defeated
         * not total loss i cleaned up the validation heavily
         */
       
        	sentinal=true;
        	for(int x=1;x<=numberOfRounds;x++) {
        		//first validate input
        		comptuterRoll= rand.nextInt(2);
        		
        		while(validationAttempts<MAX_ATTEMPTS_VALIDATION) {
        			//if for validation attempts
        			System.out.println("\nSelect one: ");
        			System.out.println("1) Rock?\n2) Paper?\n3)Scissors? ");     
        			playerInputDecision=inputReader.nextLine();
	        		validInput=inputValidation(playerInputDecision, sentinal);
	        		if(validInput==true) {validationAttempts=0; break;}
        			switch(validationAttempts) {
        			case 2:
        				System.out.println("I see how it is...\nPerhaps some other time then...");
        				System.exit(0);
        			default:
        				if(validInput==false){
	                		System.out.println(playerInputDecision+"? "
	                				+"Let's try that again...");
	                		validationAttempts++;
	                		break;
	        			}
        			}
        		
    				}
        		
        		
        		//user input is valid thus now to do something with said input
				try {			
					playerChooice=Integer.parseInt(playerInputDecision);
					//switch isn't working
					
					switch(playerChooice) {
					case 1:
						System.out.print("You threw Rock!\t");						
						break;
					case 2:
						System.out.print("You threw Paper!\t");
						break;
					case 3:
						System.out.print("You threw Scissors!\t");
						break;
					}
					switch(comptuterRoll) {
					case 0:
						System.out.println("I threw Rock!");
						break;
					case 1:
						System.out.println("I threw Paper!");
						break;
					case 2:
						System.out.println("I threw Scissors!");
						break;
					}
					outputNumbers=rockPaperScissorShoot(playerChooice, comptuterRoll);
					}
				catch(Exception e) {
					
					outputNumbers=rockPaperScissorShoot(playerInputDecision, comptuterRoll);
					System.out.print("You threw "+playerInputDecision+"!\t");
					switch(comptuterRoll) {
					case 0:
						System.out.println("I threw Rock!");
						break;
					case 1:
						System.out.println("I threw Paper!");
						break;
					case 2:
						System.out.println("I threw Scissors!");
						break;
						}
				}
				
				numberOfTies+=outputNumbers[0];
				numberOfWins+=outputNumbers[1];
				numberOfLosses+=outputNumbers[2];

    			if(outputNumbers[0]==1) {System.out.println("\nIt's a Tie!");}
    			if(outputNumbers[1]==1) {System.out.println("\nLooks like you lost this round.");}
    			if(outputNumbers[2]==1) {System.out.println("\nCongrats, you won this round.");}
    			System.out.println("\t\tWins: "+numberOfWins+"\t\tLosses: "+numberOfLosses+"\tTies: "
    			+numberOfTies);
				
			
        		
        		
        		
        		
        	}
        	if(numberOfLosses==numberOfWins) {System.out.println("GG! Looks like it's a draw.\nPlay again?");}
        	if(numberOfLosses<numberOfWins) {System.out.println("Well played! You beat me!\nPlay again?");}
        	if(numberOfLosses>numberOfWins) {System.out.println("GG! You lost...\nPlay again?");}
        	/*
        	 * all that is left is to loop thru how many rounds
        	 */
        	//playerDecisionToPlay=false;
        	}
        
        
        

	inputReader.close();}
	
	//should this be a boolean--no its win, lose, tie--> (123)
	public static int[] rockPaperScissorShoot(int playerSigilChoice, int comptuterRoll) { 
		//Random rand= new Random();
		 //int upperBound=2;
		 //int comptuterRoll= rand.nextInt(upperBound);
		//i'm silly, i need to display the comp roll XD
		 int[] arr={0,0,0};
		 int x=whoWon(playerSigilChoice,comptuterRoll);
		 if(x==0){
				arr[0]=1;			
			}else if(x==1) {
				arr[1]=1;
			} else if(x==2){
				arr[2]=1;
			}
		 return arr;
			 
		 
		 
	}
	public static int[] rockPaperScissorShoot(String playerSigilChoice, int comptuterRoll) { 
		//Random rand= new Random();
		//int upperBound=2;
		//int comptuterRoll= rand.nextInt(upperBound);
	
		int[] arr= {0,0,0};
		int x=whoWon(playerSigilChoice,comptuterRoll);
		if(x==0){
			arr[0]=1;			
		}else if(x==1) {
			arr[1]=1;
		} else if(x==2){
			arr[2]=1;
		}
		return arr;
		
	}
	
	/*
	 * might be able to over load this
	 */
	public static Boolean inputValidation(String inputResponse){
		Boolean output=null;
		if(inputResponse == null||inputResponse.isEmpty()) {
			output=false;
		}
		else if(inputResponse.equalsIgnoreCase("yes")
				||inputResponse.equalsIgnoreCase("y")
				||inputResponse.equalsIgnoreCase("1")) {
			output=true;
		}
		else if(inputResponse.equalsIgnoreCase("no")
				||inputResponse.equalsIgnoreCase("n")
				||inputResponse.equalsIgnoreCase("2")) {
			output=false;
		}
		
		else {
			output=false;
		}
		
		return output;
		
	} 
	public static Boolean inputValidation(int inputResponse){
		Boolean output=null;
		if(inputResponse<1||inputResponse>10) {
			output=false;
		}else if(inputResponse>=1&&inputResponse<=10) {
			output=true;
		}
		else {
			output=false;
		}
		return output;
	}
	public static Boolean inputValidation(String inputResponse, Boolean sentinal){
	Boolean output=null;
	if((inputResponse.equalsIgnoreCase("rock")
			||inputResponse.equalsIgnoreCase("paper")
			||inputResponse.equalsIgnoreCase("Scissors")
			||inputResponse.equalsIgnoreCase("1")
			||inputResponse.equalsIgnoreCase("2")
			||inputResponse.equalsIgnoreCase("3")
			||inputResponse.equalsIgnoreCase("r")
			||inputResponse.equalsIgnoreCase("p")
			||inputResponse.equalsIgnoreCase("s"))&&sentinal==true) {
		output=true;
			}else {
				output=false;
			}
		return output;

	}

	public static int whoWon(int playerRoll, int computerRoll) {
	/*
	 * permutations are
	 * r:r s:s p:p which are all just == (tie)  
	 * r<p s<r p<s which are all comp wins
	 * r>s s>p p>r which are all player wins
	 */
	int outputOfWinner;
	if((playerRoll-1)==computerRoll) {
		outputOfWinner=0;
	} else if(
			((playerRoll-1)==0&&computerRoll==1)//player rolled rock comp rolled paper
			||((playerRoll-1)==1&&computerRoll==2)//player rolled paper comp rolled scissors
			||((playerRoll-1)==2&&computerRoll==0))//player rolled scissors and comp rolled rock
			{
			outputOfWinner=1;
			}
	else {
		outputOfWinner=2;
	}
	return outputOfWinner;
		
	
	
}
	public static int whoWon(String playerRoll, int computerRoll) {
	int outputOfWinner;
	String playerStringComparator="";
	playerStringComparator=playerRoll.substring(0, 1);
	//in case of tie
	
	if(
			((playerStringComparator.equalsIgnoreCase("r"))&&computerRoll==0)//r'r
			||((playerStringComparator.equalsIgnoreCase("p"))&&computerRoll==1)//p'p
			||((playerStringComparator.equalsIgnoreCase("s"))&&computerRoll==2)) {
		outputOfWinner=0;
	} else if( 
			((playerStringComparator.equalsIgnoreCase("r"))&&computerRoll==1)//player rolled rock comp rolled paper
			||((playerStringComparator.equalsIgnoreCase("p"))&&computerRoll==2)//player rolled paper comp rolled scissors
			||((playerStringComparator.equalsIgnoreCase("s"))&&computerRoll==0))//player rolled scissors and comp rolled rock
			{
			outputOfWinner=1;
			}
	else {
		outputOfWinner=2;
	}
	return outputOfWinner;
}
}
