package com.mThree.DAO;

@SuppressWarnings("serial") // see below comments 
public class ReleaseTheKrakenException extends Exception{

	/**
	 * Serialization number:
	 * what is a serialization number? well for scope of this course I know its 100% not necessary.
	 * but eclispe was talking about it and well there's 2 options
	 * 1) add suppress warning about "serial" which can be multiple ways
	 * 2) just have eclipse generate it below. which I opted to...
	 * WHAT does this number do? and what is is used for? Well nothing for my scope :D
	 * its used to stored the status of a program in an external file or some other process
	 * has something to do with Throwable implementing Serializable interface
	 * 
	 *  
	 *  (some time later)
	 *  well upon further researching seems that this isn't best practices. to generate a serial number 
	 *  it matters not in the long run for this application, but best practice is best practice. 
	 *  basically will i be serializing my application? no (I really don't know what that means either)
	 * (one second)
	 *  according to oracle its converting a state to a byte stream 
	 *  	and to do that so we can deconvert it as a copy 
	 *  and example they list is a button which i guessing the press of the button is serializing
	 *  and the storing of the data from said press is deserializing??
	 *  Question: could serialization help in this application? not that I'm aware of. 
	 *  I mean why would i want to convert an object to Bytes... actually no... it useful, but not for me
	 *  if i wanted to encrypt the data i'd serialize it and store it as byte code and then jumble the bytes 
	 *  or add more junk to it like a ... oh i forgot the term... I think its RSA encryption hash? 
	 *  but basically id be encrypting by adding a whole bunch of stuff to the code and or jumbling according to a private key
	 * 
	 *  however, none of this is useful here. I mean it could be but returning to this number thing
	 *  
	 *  man i've hit a wall and my head hurts
	 *  I think that this number is only useful for the process i said above. without it "as is" classes won't work as expected and can break. 
	 *  commenting out and adding suppress warnings :D
	 */
	//private static final long serialVersionUID = -3330493792176001174L;
	
	/*
	 * I'm critical of making a custom exception class again, cause the rule is make one custom for something "exceptional"
	 * But then again the one mThree wants to build is rather generic.
	 * in apex one makes a custom exception class as an exception suite essentially where u have all the possible exceptions
	 * and then u catch or stop as needed depending on the situation.
	 * going off the mthree class roster exception
	 * making 1 constructor that is then overloaded. first one handles things we weren't expecting
	 * the second one is for our try catch blocks.
	 * to be fair the exceptions we can have are related to the string methods and the parse int function when i need to do that. 
	 * other than that there could be validation or other issues. To be fair the program is so simple its very difficult to think of possible points of failure
	 *  
	 */
	 
	public ReleaseTheKrakenException(String message) {
		super(message);
	}
	
	public ReleaseTheKrakenException(String message, Throwable cause) {
		super(message, cause);
	}

}
