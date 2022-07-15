/** *****************************************************************************
 *  MODULE:   Movie.java
 *  SYNOPSIS: Class representing a movie. Used in conjunction with the Observer
 *            design pattern project.
 ***************************************************************************** */
package observerpattern;

public class Movie {
    private String title;
    private String genre;
    private String yearReleased;
    private Double numStars;

    /**
     * Default constructor
     *
     * @param title Title of the movie
     * @param genre Genre of the movie
     * @param yearReleased The year the movie was released to theaters
     * @param numStars Rating in number of stars (can be fractional)
     */
    public Movie(String title, String genre, String yearReleased, Double numStars) {
        this.title = title;
        this.genre = genre;
        this.yearReleased = yearReleased;
        this.numStars = numStars;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre Genre of the movie, e.g., "Horror"
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @return yearReleased
     */
    public String getYearReleased() {
        return yearReleased;
    }

    /**
     *
     * @param yearReleased Year the movie was released to theaters
     */
    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    /**
     *
     * @return numStars
     */
    public Double getNumStars() {
        return numStars;
    }

    /**
     *
     * @param numStars Number of stars on IMDB (Can be fractional)
     */
    public void setNumStars(Double numStars) {
        this.numStars = numStars;
    }

    /**
     * Implements the toString method for class fields
     */
    @Override
    public String toString() {
        return "Title: " + title + " Genre: " + genre + " Year: " + yearReleased + " Stars: " + numStars;
    }
}
