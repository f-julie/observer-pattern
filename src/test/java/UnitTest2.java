/*******************************************************************************
 *  MODULE:   UnitTest2.java
 *  SYNOPSIS: Unit test for the Concrete Subject class. Tests the addition of a
 *            movie object to its state. No Concrete Observers are attached.
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest2 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest2() {
        Service service = new Service();
        ArrayList<Movie> state;
        String title;

        System.out.println(TEXT_BLUE + "Unit Testing 2 - Concrete Subject Class:" + TEXT_RESET);
        System.out.println("Testing addition of Movie to Service");

        Movie m = new Movie("Firestarter", "Horror", "2022", 3.5);
        System.out.println(TEXT_BLUE + "Insertion 1 - Adding Firestarter" + TEXT_RESET);

        // Test for a Subject state of an ArrayList containing the Movie object m
        service.addMovie(m);
        state = service.getMovies();
        title = state.get(0).getTitle();
        assertEquals(title, "Firestarter");
        System.out.print(TEXT_GREEN + "Test 2 passed: " + TEXT_RESET);
        System.out.println("State from Subject (One Movie) is correct. No observers attached.");
    }
}
