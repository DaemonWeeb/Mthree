/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   this component is the "brains" of the operation, it will control when the menu system is displayed.
 *   its more of a conductor to be honest. the band makes the music with the player using hte instrument to make the music
 *   but the conductor controls the tempo and when and where the song goes . 
 *  
 */
package com.mThree.Controller;

import com.mThree.DAO.*;
import com.mThree.DTO.*;
import com.mThree.UI.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DVDLibraryController {
	// using our UI classes
	private UserIO io = new UserIOConsoleImpl(); // input/output shennanigans
	private DVDLibraryView view; // menu view shennanigans
	private DVDLibraryDAO dao;// our DAO shennanigans

	public DVDLibraryController(DVDLibraryDAO dao, DVDLibraryView view) {
	    this.dao = dao;
	    this.view = view;
	}

	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		try {
			while (keepGoing) {

				// using the menuSelection getter
				menuSelection = getMenuSelection();

				// menuSelection = io.readInt("Please select from the"
				// + " above choices.", 1, 5);

				switch (menuSelection) {
				case 1:
					createDVD();
					break;
				case 2:
					removeDVD();
					break;
				case 3:
					editDVD();
					break;
				case 4:
					listDVDs();
					break;
				case 5:
					getDVD();
					break;
				case 6:
					findDVDs();
					break;
				case 7:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}

			}

			exitMessage();
			// io.print("GOOD BYE");
		} catch (DVDLibraryDAOException e) {
		}
	}

	// getter for the menu selections
	// refactored to work with view
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}

	// at the point we made one for the first part of the menu
	// so lets got do this for all of them
	private void createDVD() throws DVDLibraryDAOException {
		view.displayCreateDVDBanner();
		DVD newDVD = view.getNewDVDInfo();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.displayCreateSuccessBanner();
	}

	private void listDVDs() throws DVDLibraryDAOException {
		view.displayDVDListBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDList(dvdList);
	}

	private void getDVD() throws DVDLibraryDAOException {
		view.displayDisplayDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		DVD dvd = dao.getDVD(dvdTitle);
		view.displayDVD(dvd);
	}

	private void removeDVD() throws DVDLibraryDAOException {
		view.displayRemoveDVDBanner();
		String title = view.getDVDTitleChoice();
		DVD removedDVD = dao.removeDVD(title);
		view.displayRemoveResult(removedDVD);
	}

	private void exitMessage() {
		view.displayExitBanner();
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void editDVD() throws DVDLibraryDAOException {
		view.displayEditDVDBanner();
		String title = view.getDVDTitleChoice();
		DVD dvdToEdit = dao.getDVD(title);
		if (dvdToEdit == null) {
			view.displayNullDVD();
		} else {
			view.displayDVD(dvdToEdit);
			int editMenuSelection = 0;
			boolean keepGoing = true;
			while (keepGoing) {
				editMenuSelection = view.printEditMenuAndGetSelection();

				switch (editMenuSelection) {
				case 1:
					editReleaseDate(title);
					break;
				case 2:
					editMpaaRating(title);
					break;
				case 3:
					editDirectorName(title);
					break;
				case 4:
					editUserRating(title);
					break;
				case 5:
					editStudioName(title);
					break;
				case 6:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
				if (keepGoing == false) {
					break;
				}
			}
		}
	}

	private void editReleaseDate(String title) throws DVDLibraryDAOException {
		view.displayEditReleaseDateBanner();
		LocalDate newReleaseDate = view.getReleaseDate();
		DVD editedDVD = dao.changeReleaseDate(title, newReleaseDate);
		view.displayEditResult();
	}

	private void editMpaaRating(String title) throws DVDLibraryDAOException {
		// view.displayEditMpaaRatingBanner();
		String newMpaaRating = view.getMpaaRating();
		DVD editedDVD = dao.changeMpaaRating(title, newMpaaRating);
		view.displayEditResult();
	}

	private void editDirectorName(String title) throws DVDLibraryDAOException {
		// view.displayEditDirectorNameBanner();
		String newDirectorName = view.getDirectorName();
		DVD editedDVD = dao.changeDirectorName(title, newDirectorName);
		view.displayEditResult();
	}

	private void editUserRating(String title) throws DVDLibraryDAOException {
		String newUserRating = view.getUserRating();
		DVD editedDVD = dao.changeUserRating(title, newUserRating);
		view.displayEditResult();
	}

	private void editStudioName(String title) throws DVDLibraryDAOException {
		String newStudioName = view.getStudioName();
		DVD editedDVD = dao.changeStudioName(title, newStudioName);
		view.displayEditResult();
	}

	private void findDVDs() throws DVDLibraryDAOException {
		view.displayFindDVDsBanner();
		int findDVDsSelection = 0;
		boolean keepGoing = true;
		while (keepGoing) {
			findDVDsSelection = view.printFindMenuAndGetSelection();
			switch (findDVDsSelection) {
			case 1:
				findMoviesByYears();
				break;
			case 2:
				findMoviesByMpaaRating();
				break;
			case 3:
				findMoviesByDirector();
				break;
			case 4:
				findMoviesByStudio();
				break;
			case 5:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
//	                if (keepGoing == false) {
//	                    break;
		}
	}

	private void findMoviesByYears() throws DVDLibraryDAOException {
		int x = view.getYears();
		Map<String, DVD> filteredDVDs = dao.getDVDsByYears(x);
		view.displayDVDs(filteredDVDs);
	}

	private void findMoviesByMpaaRating() throws DVDLibraryDAOException {
		String mpaaRating = view.getMpaaRating();
		Map<String, DVD> filteredDVDs = dao.getDVDsByMpaaRating(mpaaRating);
		view.displayDVDs(filteredDVDs);
	}

	private void findMoviesByDirector() throws DVDLibraryDAOException {
		String director = view.getDirectorName();
		Map<String, DVD> filteredDVDs = dao.getDVDsByDirector(director);
		view.displayDVDs(filteredDVDs);
	}

	private void findMoviesByStudio() throws DVDLibraryDAOException {
		String studio = view.getStudioName();
		Map<String, DVD> filteredDVDs = dao.getDVDsByStudio(studio);
		view.displayDVDs(filteredDVDs);
	}
}
