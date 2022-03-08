/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   The view is responsible for all user interactions.
 */
package com.mThree.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.mThree.DTO.DVD;

public class DVDLibraryView {
	private UserIO io;

	public DVDLibraryView(UserIO io) {
		this.io = io;
	}

	// functionality for printing the menu and getting the user's selection
	public int printMenuAndGetSelection() {
		io.print("Library Main Menu");
		io.print("1. Add new DVD to Library");
		io.print("2. Remove a DVD to Library");
		io.print("3. Edit a DVD to Library");
		io.print("4. List all DVDs in the Library  ");
		io.print("5. Display DVD information");
		io.print("6. Find DVDs?");
		io.print("7. Exit");

		return io.readInt("Please select from the above choices.", 1, 7);
	}

	// the methoad class roster but for getting new DVD
	public DVD getNewDVDInfo() {
		String title = io.readString("Please enter the DVD title");
		LocalDate releaseDate = io.readDate("Please enter the DVD release date");
		String MpaaRating = io.readString("Please enter the MPAA rating");
		String directorName = io.readString("Please enter the director's name");
		String userRating = io.readString("Please enter your rating of the DVD");
		String studio = io.readString("Please enter the DVD studio");

		// Instantiating a new DVD object using the title to satisfy the constructors
		// requirements
		DVD currentDVD = new DVD(title);
		currentDVD.setReleaseDate(releaseDate);
		currentDVD.setMpaaRating(MpaaRating);
		currentDVD.setDirectorName(directorName);
		currentDVD.setUserRating(userRating);
		currentDVD.setStudio(studio);
		return currentDVD;
	}

	// banner stuff-- might change
	public void displayCreateDVDBanner() {
		io.print("-·.¸¸.- Create DVD -·.¸¸.-");
	}

	public void displayCreateSuccessBanner() {
		io.readString("DVD successfully created. Please hit enter to continue");
	}

	public void displayDVDList(List<DVD> dvdList) {
		String dvdHeadings = String.format("%25s | %12s | %4s | %17s | %7s | %25s", // this percent thing is nifty.
				"Title", "Release Date", "MPAA", "Director Name", "Rating", "Studio");
		io.print(dvdHeadings);
		io.print(
				"-.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.-");
		for (DVD currentDVD : dvdList) {
			String dvdInfo = String.format("%25s | %12s | %4s | %17s | %7s | %25s", currentDVD.getTitle(),
					currentDVD.getReleaseDate(), currentDVD.getMpaaRating(), currentDVD.getDirectorName(),
					currentDVD.getUserRating(), currentDVD.getStudio());
			io.print(dvdInfo);
		}
		io.readString("Please hit enter to continue");
	}

	public void displayDVDListBanner() {
		io.print("-·.¸¸.- Display all DVDs -·.¸¸.-");
	}

	public void displayDisplayDVDBanner() {
		io.print("-·.¸¸.- Display DVD -·.¸¸.-");
	}

	public String getDVDTitleChoice() {
		return io.readString("Please enter the DVD title.");
	}

	public void displayDVD(DVD dvd) {
		if (dvd != null) {
			io.print("-·.¸¸.- " + dvd.getTitle() + " Summary -·.¸¸.-");
			io.print("Title: " + dvd.getTitle());
			io.print("Release date: " + dvd.getReleaseDate());
			io.print("MPAA rating: " + dvd.getMpaaRating());
			io.print("Director's name: " + dvd.getDirectorName());
			io.print("User rating: " + dvd.getUserRating());
			io.print("Studio: " + dvd.getStudio());
		} else {
			io.print("No such DVD");
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayRemoveDVDBanner() {
		io.print("-·.¸¸.- Remove DVD -·.¸¸.-");
	}

	public void displayRemoveResult(DVD dvdRecord) {
		if (dvdRecord != null) {
			io.print("DVD successfully removed.");
		} else {
			io.print("No such DVD.");
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayExitBanner() {
		io.print("Good bye!");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown command!");
	}

	public void displayEditDVDBanner() {
		io.print("-·.¸¸.- Edit DVD -·.¸¸.-");

	}

	public int printEditMenuAndGetSelection() {
		io.print("Which field do you want to change?");
		io.print("Edit DVD menu");
		io.print("1. Release date");
		io.print("2. MPAA rating");
		io.print("3. Director's name");
		io.print("4. User rating");
		io.print("5. Studio name");
		io.print("6. Exit edit menu");
		return io.readInt("Please select from the above choices.", 1, 6);
	}

	public void displayEditReleaseDateBanner() {
		io.print("-·.¸¸.- Edit DVD Release Date -·.¸¸.-");
	}

	public void displayNullDVD() {
		io.print("No such DVD");
	}

	public LocalDate getReleaseDate() {
		return io.readDate("Please enter the new DVD release date.");
	}

	public void displayEditResult(String title) {
		io.print("\""+title+"\" Successfully edited.");
	}

	public String getMpaaRating() {
		return io.readString("Please enter the new DVD MPAA rating.");
	}

	public String getDirectorName() {
		return io.readString("Please enter the new director's name.");
	}

	public String getUserRating() {
		return io.readString("Please enter the new user rating.");
	}

	public String getStudioName() {
		return io.readString("Please enter the studio name.");
	}

	public void displayErrorMessage(String errorMsg) {
		io.print("-·.¸¸.- ERROR -·.¸¸.-");
		io.print(errorMsg);
	}

	public void displayFindDVDsBanner() {
		io.print("-·.¸¸.- Find DVDS -·.¸¸.-");
	}

	public int printFindMenuAndGetSelection() {
		io.print("Find DVD menu");
		io.print("1. Find all movies released in the last (X) years");
		io.print("2. Find all movies by MPAA rating");
		io.print("3. Find all movies by director");
		io.print("4. Find all movies by Studio");
		io.print("5. Exit find DVD menu");
		return io.readInt("Please select from the above choices.", 1, 5);
	}

	public int getYears() {
		return io.readInt("How many years? ");
	}

	public String displayDVDs(Map<String, DVD> filteredDVDs) {
		if (filteredDVDs.isEmpty()) {
			io.print("No DVDs to display");
		} else {
			String dvdHeadings = String.format("%25s | %12s | %4s | %17s | %7s | %25s", "Title", "Release Date", "MPAA",
					"Director Name", "Rating", "Studio");
			io.print(dvdHeadings);
			io.print(
					"-.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.-");
			filteredDVDs.values().stream()
					.forEach((DVD) -> io.print(
							String.format("%25s | %12s | %4s | %17s | %7s | %25s", DVD.getTitle(), DVD.getReleaseDate(),
									DVD.getMpaaRating(), DVD.getDirectorName(), DVD.getUserRating(), DVD.getStudio())));
		}
		return io.readString("Please hit enter to continue");

	}

}
