/*******************************************************************************
 *  MODULE:   UnitTest7.java
 *  SYNOPSIS: Unit test for the Concrete Observer class. Tests the addition of
 *            multiple movie objects to the subject state. Multiple Concrete
 *            Observers are attached to the Concrete Subject.
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import observerpattern.Subscriber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest7 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest7() {
        Service service = new Service();
        Subscriber subscriber1 = new Subscriber(service);
        Subscriber subscriber2 = new Subscriber(service);
        ArrayList<Movie> state1, state2;
        String [] title1 = new String[4];
        String [] title2 = new String[4];
        Boolean result1, result2;

        System.out.println(TEXT_BLUE + "Unit Testing 7 - Concrete Observer and Concrete Subject Classes:" + TEXT_RESET);
        System.out.println("Testing Subscriber object notification - multiple movie additions, multiple subscribers");

        service.attach(subscriber1);
        service.attach(subscriber2);
        Movie m1 = new Movie("Firestarter", "Horror", "2022", 3.5);
        Movie m2 = new Movie("Black Panther", "Superhero", "2018", 4.5);
        Movie m3 = new Movie("Spiderman: No Way Home", "Superhero", "2021", 4.0);
        Movie m4 = new Movie("The Batman", "Superhero", "2022", 3.5);

        // Add the four Movie objects to the list, which will then constitute the state of the Subject object
        System.out.println(TEXT_BLUE + "Insertion 1 - Adding Firestarter:" + TEXT_RESET);
        service.addMovie(m1);
        System.out.println(TEXT_BLUE + "Insertion 2 - Adding Black Panther:" + TEXT_RESET);
        service.addMovie(m2);
        System.out.println(TEXT_BLUE + "Insertion 3 - Adding Spiderman: No Way Home:" + TEXT_RESET);
        service.addMovie(m3);
        System.out.println(TEXT_BLUE + "Insertion 4 - Adding The Batman:" + TEXT_RESET);
        service.addMovie(m4);

        // Get the movie list from Subscriber 1 and check for correctness
        state1 = subscriber1.getMovies();
        title1[0] = state1.get(0).getTitle();
        title1[1] = state1.get(1).getTitle();
        title1[2] = state1.get(2).getTitle();
        title1[3] = state1.get(3).getTitle();
        result1 = (title1[0].equals("Firestarter") && title1[1].equals("Black Panther") &&
                title1[2].equals("Spiderman: No Way Home") && title1[3].equals("The Batman"));

        // Get the movie list from Subscriber 2 and check for correctness
        state2 = subscriber2.getMovies();
        title2[0] = state2.get(0).getTitle();
        title2[1] = state2.get(1).getTitle();
        title2[2] = state2.get(2).getTitle();
        title2[3] = state2.get(3).getTitle();
        result2 = (title2[0].equals("Firestarter") && title2[1].equals("Black Panther") &&
                title2[2].equals("Spiderman: No Way Home") && title2[3].equals("The Batman"));
        assertTrue(result1 && result2);
        System.out.print(TEXT_GREEN + "Test 7 passed: " + TEXT_RESET);
        System.out.println("Subscriber class notification is correct (Four Movies, Two Observers)");
    }
}
