

import com.mThree.Controller.CaptainDavyJones;
import com.mThree.DAO.ManifestOfTheFlyingDutchman;
import com.mThree.DAO.TheCrewOfTheFlyingDutchmen;
import com.mThree.UI.UserIOConsoleImplementation;
import com.mThree.UI.UserIo;
import com.mThree.UI.ViewFormUpsideDown;

/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 3/1/22
 *  purpose: major project (eclipse), to make a hangman APP and show off oop and MVC design
 *  
 *  so googling dependency injection a concept i know staggeringly little about because its not well explained.
 *  there was a great quote "its a 25$ term for a 5 cent concept" 
 *  and I agree. From what I've seen Dependency injection is just calling a class and being a wrapper (not technical term) to an application
 *  basically one's lunch bag, which inside could be any thing that is lunch or maybe not even lunch maybe its spiders
 *  the point is its the bag and lets say i call and run  somethingClass inside it... well i could pass to it somethingClass that does spiders or lunch.
 *   I read mthrees version of dependency injection and frankly its staggering how i didn't get it on multiple passes
 *   
 *   but i think the issue is they're trying to explain it to uninitiated and if they explained in terms of testing
 *   like i have application x that calls on multiple other classes and i want to test each aspect of the application i can swap out for test data classes in a test factory and it should work
 *   or get an error etc. idk thats what stack overflow says and google
 *  
 *  
 *   
 *   
 */
public class HangmanApp {
	public static void main(String[] args) {
		/*we know this app only just initializes everything and is the main point of entry to run everything
		 * but it doesn't DO anything other than runs things.
		 * we know its going to import the other packages
		 * we know its going to be shell that works so we can swap out different files that are xyz and it should still work
		 */
		
		UserIo myIo = new UserIOConsoleImplementation();
		ViewFormUpsideDown myView = new ViewFormUpsideDown(myIo);
		ManifestOfTheFlyingDutchman myDao = new TheCrewOfTheFlyingDutchmen();
		CaptainDavyJones controller = new CaptainDavyJones(myDao,myView);
		controller.run();

		

	}

}
