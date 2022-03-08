
/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   we will instantiate our controller and call the run method
 */
import com.mThree.Controller.DVDLibraryController;
import com.mThree.DAO.DVDLibraryDAO;
import com.mThree.DAO.DVDLibraryDAOFileShenanigans;
import com.mThree.UI.DVDLibraryView;
import com.mThree.UI.UserIO;
import com.mThree.UI.UserIOConsoleImpl;

public class DVDLibraryApp {
	public static void main(String[] args) {
		// Dependency injection
		// Code below ensures that the App class configures, instantiates and assembles
		// the classes in the application.
		// An object should not be responsible for directly instantiating the
		// the implementation of any of its member fields that might have more than
		// one implementation.
		// The App class acts as the application assembler, it chooses the
		// implementations of the dependencies and
		// wires them together.

		UserIO myIo = new UserIOConsoleImpl();
		DVDLibraryView myView = new DVDLibraryView(myIo);
		DVDLibraryDAO myDao = new DVDLibraryDAOFileShenanigans();
		DVDLibraryController controller = new DVDLibraryController(myDao, myView);

		controller.run();

	}
}
