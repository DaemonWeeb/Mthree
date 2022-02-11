/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/9/22
 *  purpose: major project (eclipse), to make a DVD library and show off oop and MVC design
 *   This one is the properties of the dvd and associated methods
 */
package com.mThree.DTO;

import java.time.LocalDate;
import java.util.Objects;

public class DVD {
	//first all properties a DVD can have
	//title, release date, mpaa rating, director's name, studio, and user rating or note (text box/comment)
	private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String userRating;
    private String studio;
    
    
    //not going to lie i'm taking this boolean from a former MThree person 
    //and I've been following their code and comparing it the code along as well.
    //for the most part its all just been code along stuff. I understood everythign
    //BUT THEN i got here
    // THIS i have no idea what it did... key word "did"
    //its overriding the object class base function of equals() todo validation
    //i don't copy peoples code unless its copied from the source material aka the code along.
    // but this i copied to study it cause it baffled me and too me a while to figure out how its used and what for
    // Cloe Edgar came up with a plan to override the base class for when we do the hashmap it uses THIS method to generate it 
    // in conjunction with the other method after it. 
    //insane. 
    // not going to lie these 3 methods are tripping me up... i hate copying code -_- 
    /*
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.releaseDate);
        hash = 37 * hash + Objects.hashCode(this.mpaaRating);
        hash = 37 * hash + Objects.hashCode(this.directorName);
        hash = 37 * hash + Objects.hashCode(this.userRating);
        hash = 37 * hash + Objects.hashCode(this.studio);
        return hash;
    }
    
    @Override
    public String toString() {
    	return "DVD{" + "title=" + title + ", releaseDate=" + releaseDate 
    			+ ", mpaaRating=" + mpaaRating + ", directorName=" 
    			+ directorName + ", userRating=" 
    			+ userRating + ", studio=" + studio + '}';
    }
    
    */
    //now that properties are set time for getters and setters of them
    public DVD(String title) { //title is read only 
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
    
   //but this is only one DTO the other is the Library itself
   //let do that
    

}
