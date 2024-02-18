/*******************************************************************************
 *  MODULE:   UnitTest5.java
 *  SYNOPSIS: Unit test for the Concrete Observer class. Tests the addition of
 *            a movie objects to the subject state. Concrete Observer is
 *            attached to the Concrete Subject.
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import observerpattern.Subscriber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest5 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest5() {
        Service service = new Service();
        Subscriber subscriber = new Subscriber(service);
        ArrayList<Movie> state;

        System.out.println(TEXT_BLUE + "Unit Testing 5 - Concrete Observer Class:" + TEXT_RESET);
        System.out.println("Testing Subscriber object notification - one movie addition");

        service.attach(subscriber);
        Movie m = new Movie("Firestarter", "Horror", "2022", 3.5);

        System.out.println(TEXT_BLUE + "Insertion 1 - Adding Firestarter:" + TEXT_RESET);
        service.addMovie(m);

        // Get the movie list from the Subscriber and check for correctness
        state = subscriber.getMovies();
        Boolean result = (state.size() == 1 && state.get(0).getTitle() == "Firestarter");
        assertTrue(result);
        System.out.print(TEXT_GREEN + "Test 5 passed: " + TEXT_RESET);
        System.out.println("Subscriber class notification is correct (single movie)");
    }
}
