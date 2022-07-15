/*******************************************************************************
 *  MODULE:   UnitTest3.java
 *  SYNOPSIS: Unit test for the Concrete Subject class. Tests the addition of
 *            multiple movie objects to its state. No Concrete Observers are
 *            attached.
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest3 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest3() {
        Service service = new Service();
        ArrayList<Movie> state;
        String [] title = new String[4];
        Boolean result;

        System.out.println(TEXT_BLUE + "Unit Testing 3 - Concrete Subject Class:" + TEXT_RESET);
        System.out.println("Testing addition of multiple Movies to Service");

        Movie m1 = new Movie("Firestarter", "Horror", "2022", 3.5);
        Movie m2 = new Movie("Black Panther", "Superhero", "2018", 4.5);
        Movie m3 = new Movie("Spiderman: No Way Home", "Superhero", "2021", 4.0);
        Movie m4 = new Movie("The Batman", "Superhero", "2022", 3.5);

        // Add the four Movie objects to the list, which will then constitute the state of the Subject object
        System.out.println(TEXT_BLUE + "Insertion 1 - Adding Firestarter" + TEXT_RESET);
        service.addMovie(m1);
        System.out.println(TEXT_BLUE + "Insertion 2 - Adding Black Panther" + TEXT_RESET);
        service.addMovie(m2);
        System.out.println(TEXT_BLUE + "Insertion 3 - Adding Spiderman: No Way Home" + TEXT_RESET);
        service.addMovie(m3);
        System.out.println(TEXT_BLUE + "Insertion 4 - Adding The Batman" + TEXT_RESET);
        service.addMovie(m4);

        // Get the movie list from the Service and check for correctness
        state = service.getMovies();
        title[0] = state.get(0).getTitle();
        title[1] = state.get(1).getTitle();
        title[2] = state.get(2).getTitle();
        title[3] = state.get(3).getTitle();
        result = (title[0].equals("Firestarter") && title[1].equals("Black Panther") &&
                  title[2].equals("Spiderman: No Way Home") && title[3].equals("The Batman"));
        assertTrue(result);
        System.out.println(TEXT_GREEN + "Test 3 passed: " + TEXT_RESET);
        System.out.println("State from Subject (Four Movies) is correct. No observers attached");
    }
}
