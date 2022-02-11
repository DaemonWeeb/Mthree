/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *  these are the commands to be used by user that do something to the DVD/library DTO
 */
package com.mThree.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.mThree.DTO.DVD;

public interface DVDLibraryDAO {
	/**
	 * Adds the given DVD to the Library and associates it with the given title. If
	 * there is already a DVD associated with the given title it will return that
	 * DVD object, otherwise it will return null.
	 *
	 * @param title with which DVD is to be associated
	 * @param DVD   DVD to be added to the Library
	 * @return the DVD object previously associated with the given title if it
	 *         exists, null otherwise
	 * @throws com.mThree.DAO.DVDLibraryDAOException
	 */
	DVD addDVD(String title, DVD dvd) throws DVDLibraryDAOException;

	/**
	 * Removes from the Library the DVD associated with the given title. Returns the
	 * DVD object that is being removed or null if there is no DVD associated with
	 * the given id
	 *
	 * @param title of DVD to be removed
	 * @return DVD object that was removed or null if no DVD was associated with the
	 *         given title
	 * @throws com.mThree.DAO.DVDLibraryDAOException
	 */
	DVD removeDVD(String title) throws DVDLibraryDAOException;

	/**
	 * Returns a List of all DVDs in the Library.
	 * 
	 * @return List containing all DVDs in the Library.
	 * @throws com.mThree.DAO.DVDLibraryDAOException
	 */
	List<DVD> getAllDVDs() throws DVDLibraryDAOException;

	/**
	 * Returns the DVD object associated with the given title. Returns null if no
	 * such DVD exists
	 *
	 * @param title of the DVD to retrieve
	 * @return the DVD object associated with the given title, null if no such DVD
	 *         exists
	 * @throws com.mThree.DAO.DVDLibraryDAOException
	 */
	DVD getDVD(String title) throws DVDLibraryDAOException;
	
	/**
     * Edits the DVD release date from the library the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if there is no DVD
     *  associated with the given title.
     * @param title title of DVD to be edited
     * @param releaseDate release date of DVD to be changed to
     * @return DVD object that was edited or null if no DVD was associated with the 
     * given DVD title
     * @throws com.mThree.DAO.DVDLibraryDAOException
     */
    DVD changeReleaseDate(String title, LocalDate releaseDate)throws DVDLibraryDAOException;
    
    /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param mpaaRating MPAA rating of DVD to be changed to    
     * @return DVD object that was edited or null if no DVD was associated with the
     * given DVD title
     * @throws com.mThree.DAO.DVDLibraryDAOException    
     */
    DVD changeMpaaRating(String title, String mpaaRating)throws DVDLibraryDAOException;
    
    
    /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param directorName director name of DVD to be changed to    
     * @return DVD object that was edited or null if no DVD was associated with the
     * given DVD title
     * @throws com.mThree.DAO.DVDLibraryDAOException    
     */    
    DVD changeDirectorName(String title, String directorName)throws DVDLibraryDAOException;
    
    
      /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param userRating user rating of DVD to be changed to    
     * @return DVD object that was edited or null if no DVD was associated with the
     * given DVD title    
     * @throws com.mThree.DAO.DVDLibraryDAOException    
     */     
    DVD changeUserRating(String title, String userRating)throws DVDLibraryDAOException;
    
    
      /**
     * Edits the DVD studio name from the library the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param studioName name of the studio of DVD to be changed to    
     * @return DVD object that was edited or null if no DVD was associated with the
     * given DVD title    
     * @throws com.mThree.DAO.DVDLibraryDAOException    
     */     
    DVD changeStudioName(String title, String studioName)throws DVDLibraryDAOException; 

    //for searches getters of maps.
    Map<String, DVD> getDVDsByYears(int years) throws DVDLibraryDAOException;
    
    Map<String, DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryDAOException;
    
    Map<String, DVD> getDVDsByDirector(String directorName) throws DVDLibraryDAOException;
    
    Map<String, DVD> getDVDsByStudio(String studioName) throws DVDLibraryDAOException;
    
}
