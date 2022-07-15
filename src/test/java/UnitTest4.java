/*******************************************************************************
 *  MODULE:   UnitTest4.java
 *  SYNOPSIS: Unit test for the Concrete Observer class. Tests the addition of
 *            a movie objects to the subject state. Concrete Observer is not
 *            attached to the Concrete Subject.
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import observerpattern.Subscriber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest4 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest4() {
        Service service = new Service();
        Subscriber subscriber = new Subscriber(service);
        ArrayList<Movie> state;

        System.out.println(TEXT_BLUE + "Unit Testing 4 - Concrete Observer Class:" + TEXT_RESET);
        System.out.println("Testing Subscriber object notification");

        Movie m = new Movie("Firestarter", "Horror", "2022", 3.5);
        System.out.println(TEXT_BLUE + "Insertion 1 - Adding Firestarter" + TEXT_RESET);

        service.addMovie(m);
        // Test for an empty ArrayList as the Observer state. Observer is not attached to Subject
        state = subscriber.getMovies();
        Boolean result = state.isEmpty();
        assertTrue(result);
        System.out.print(TEXT_GREEN + "Test 4 passed: " + TEXT_RESET);
        System.out.println("Subscriber class notification is correct (One movie added, but no observers attached)");
    }
}
