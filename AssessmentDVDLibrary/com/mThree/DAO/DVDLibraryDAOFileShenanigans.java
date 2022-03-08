/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   
 *  
 */
package com.mThree.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mThree.DTO.DVD;

public class DVDLibraryDAOFileShenanigans implements DVDLibraryDAO {

	// the hash map i am doing... string and DVD
	private Map<String, DVD> DVDs = new HashMap<>(); // hmm might change that to lowercase but it gets highlighted by
														// eclipse and i like it :D
	// da file
	private final String LIBRARY_FILE;
	private final String DELIMITER = "::"; // now we talked about this in class and double colon is kinda foolproof

	// default constructor

	public DVDLibraryDAOFileShenanigans() {
		LIBRARY_FILE = "DVDLibrary.txt";
	}

	@Override
	public DVD addDVD(String title, DVD dvd) throws DVDLibraryDAOException {
		// loadLibrary reads the LIBRARY_FILE into memory.
		loadLibrary();
		// New DVD is added to the DVDs HashMap.
		DVD newDVD = DVDs.put(title, dvd);
		// writeLibrary writes all the DVDs in the DVD library out to a LIBRARY_FILE.
		writeLibrary();
		return newDVD;
		
	}
	// with add done do the rest.

	@Override
	public DVD removeDVD(String title) throws DVDLibraryDAOException {
		loadLibrary();
		DVD removedDVD = DVDs.remove(title);
		writeLibrary();
		return removedDVD;

	}

	@Override
	public List<DVD> getAllDVDs() throws DVDLibraryDAOException {
		loadLibrary();
		return new ArrayList<DVD>(DVDs.values());
	}

	@Override
	public DVD getDVD(String title) throws DVDLibraryDAOException {
		loadLibrary();
		return DVDs.get(title);
	}

	@Override
	public DVD changeReleaseDate(String title, LocalDate releaseDate) throws DVDLibraryDAOException {
		loadLibrary();
		
		DVD dvdToEdit = DVDs.get(title);
		dvdToEdit.setReleaseDate(releaseDate);
		writeLibrary();
		return dvdToEdit;
	}

	@Override
	public DVD changeMpaaRating(String title, String mpaaRating) throws DVDLibraryDAOException {
		loadLibrary();
		DVD dvdToEdit = DVDs.get(title);
		dvdToEdit.setMpaaRating(mpaaRating);
		writeLibrary();
		return dvdToEdit;
	}

	@Override
	public DVD changeDirectorName(String title, String directorName) throws DVDLibraryDAOException {
		loadLibrary();
		DVD dvdToEdit = DVDs.get(title);
		dvdToEdit.setDirectorName(directorName);
		writeLibrary();
		return dvdToEdit;
	}

	@Override
	public DVD changeUserRating(String title, String userRating) throws DVDLibraryDAOException {
		loadLibrary();
		DVD dvdToEdit = DVDs.get(title);
		dvdToEdit.setUserRating(userRating);
		writeLibrary();
		return dvdToEdit;
	}

	@Override
	public DVD changeStudioName(String title, String studioName) throws DVDLibraryDAOException {
		loadLibrary();
		DVD dvdToEdit = DVDs.get(title);
		dvdToEdit.setStudio(studioName);
		writeLibrary();
		return dvdToEdit;
	}

	@Override
	public Map<String, DVD> getDVDsByYears(int years) throws DVDLibraryDAOException {
		LocalDate now = LocalDate.now();
		LocalDate sinceThisDate = now.minusYears(years);
		loadLibrary();
		Map<String, DVD> dvdsByYears = DVDs.entrySet().stream()
				.filter((DVD) -> DVD.getValue().getReleaseDate().isAfter(sinceThisDate))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return dvdsByYears;
	}

	@Override
	public Map<String, DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryDAOException {
		loadLibrary();
		Map<String, DVD> dvdsMpaaRating = DVDs.entrySet().stream()
				.filter((DVD) -> DVD.getValue().getMpaaRating().equalsIgnoreCase(mpaaRating))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return dvdsMpaaRating;
	}

	@Override
	public Map<String, DVD> getDVDsByDirector(String directorName) throws DVDLibraryDAOException {
		loadLibrary();
		Map<String, DVD> dvdsByDirector = DVDs.entrySet().stream()
				.filter((DVD) -> DVD.getValue().getDirectorName().equalsIgnoreCase(directorName))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return dvdsByDirector;
	}

	@Override
	public Map<String, DVD> getDVDsByStudio(String studioName) throws DVDLibraryDAOException {
		loadLibrary();
		Map<String, DVD> dvdsByStudio = DVDs.entrySet().stream()
				.filter((DVD) -> DVD.getValue().getStudio().equalsIgnoreCase(studioName))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return dvdsByStudio;

	}

	// Data Marshalling & Unmarshalling
	/**
	 * marshallDVD organizes the DVD information from an in memory object into a
	 * line of text, so it is in an appropriate format for writing it to permanent
	 * storage.
	 * 
	 * @param aDVD a DVD object in memory
	 * @return a String consisting of the format DVD title::release date::MPAA
	 *         rating::director name::user rating::studio
	 */
	private String marshallDVD(DVD aDVD) {
		// A DVD object needs to be turned into a line of text for the file.
		// E.g, need to turn an in memory object to end up like this:
		// There Will be Blood::2007::R::Paul Thomas Anderson::AMAZING!::Paramount
		// Vantage

		// the properties are got out of the DVD object using getters and these are
		// concatenated with the delimiter as a kind of spacer.
		String dvdAsText = aDVD.getTitle() + DELIMITER;
		dvdAsText += aDVD.getReleaseDate() + DELIMITER;
		dvdAsText += aDVD.getMpaaRating() + DELIMITER;
		dvdAsText += aDVD.getDirectorName() + DELIMITER;
		dvdAsText += aDVD.getUserRating() + DELIMITER;
		dvdAsText += aDVD.getStudio();
		return dvdAsText;
	}

	/**
	 * UnmarshallDVD translates a line of text into a DVD object.
	 * 
	 * @param dvdAsText string and parses it into dvd object
	 * @return returns a fleshed out DVD object
	 */
	private DVD unmarshallDVD(String dvdAsText) {
		// dvdAsText is expecting a line read in from our file.
		// E.g., it might look like this:
		// There Will be Blood::2007::R::Paul Thomas Anderson::AMAZING!::Paramount
		// Vantage);
	
		//
		// This line is then split at the DELIMITER (::), leaving an array of Strings,
		// stored as dvdTokens, which should look like this:
		// _____________________________________________________________________________________
		// | | | | | | |
		// |There Will be Blood |2007| R |Paul Thomas Anderson|AMAZING! |Paramount
		// Vantage |
		// | | | | | | |
		// -------------------------------------------------------------------------------------
		// [0] [1] [2] [3] [4] [5]

		String[] dvdTokens = dvdAsText.split(DELIMITER);
		// Given the pattern above, the DVD title is in index 0 of the array.
		String title = dvdTokens[0];
		String releaseDate = dvdTokens[1];
		String mpaaRating = dvdTokens[2];
		String directorName = dvdTokens[3];
		String userRating = dvdTokens[4];
		String studio = dvdTokens[5];

		// A new DVD object is created using the title to satisfy the
		// requirements of the DVD constructor
		DVD dvdFromFile = new DVD(title);
		// The remaining tokens are then set into the DVD object using the appropriate
		// setters.
		dvdFromFile.setReleaseDate(LocalDate.parse(releaseDate));
		dvdFromFile.setMpaaRating(mpaaRating);
		dvdFromFile.setDirectorName(directorName);
		dvdFromFile.setUserRating(userRating);
		dvdFromFile.setStudio(studio);
		return dvdFromFile;
	}

	/**
	 * loadLibrary reads the LIBRARY_FILE into memory. same as load roaster, just
	 * different name
	 */

	private void loadLibrary() throws DVDLibraryDAOException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
		} catch (FileNotFoundException e) {
			throw new DVDLibraryDAOException("-_-' Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// curentDVD holds the most recent DVD unmarshalled
		DVD currentDVD;
		// Go through LIBRARY_FILE line by line, decoding each line into a DVD
		// object by calling the unmarshallDVD method. Process while we have more
		// more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a DVD
			currentDVD = unmarshallDVD(currentLine);

			// The DVD title is used as a map key to put the currentDVD ino the map
			DVDs.put(currentDVD.getTitle(), currentDVD);
		}
		
		scanner.close();
	}

	/**
	 * writeLibrary writes all the DVDs in the DVD library out to a LIBRARY_FILE.
	 * The DVD objects in the DVD map will be converted to text one by one, using
	 * the marshallDVD method, spaced by the delimiter. The string will then be
	 * written to an output file.
	 * 
	 * @throws DVDLibraryDAOException if an error occurs writing to the file
	 */
	private void writeLibrary() throws DVDLibraryDAOException {
		// We are translating the IOException to an application specific exception
		// and then simple throwing it i.e. reporting it to the code that called us.

		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(LIBRARY_FILE));
		} catch (IOException e) {
			throw new DVDLibraryDAOException("Could not save DVD data", e);
		}
		String dvdAsText;
		List<DVD> dvdList = this.getAllDVDs();
		for (DVD currentDVD : dvdList) {
			// turn a DVD into a string
			dvdAsText = marshallDVD(currentDVD);
			// write the DVD object to to the file;
			out.println(dvdAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

}// cause shenanigans are a foot! ^_^
