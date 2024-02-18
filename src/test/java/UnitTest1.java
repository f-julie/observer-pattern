/*******************************************************************************
 *  MODULE:   UnitTest1.java
 *  SYNOPSIS: Unit test for the Concrete Subject class. Tests default constructor
 ******************************************************************************/
import observerpattern.Movie;
import observerpattern.Service;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest1 {
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";

    @Test
    void unitTest1() {
        Service service = new Service();
        ArrayList<Movie> state;

        System.out.println(TEXT_BLUE + "Unit Testing 1 - Concrete Subject Class:" + TEXT_RESET);
        System.out.println("Testing Service object constructor");

        // Test for an empty ArrayList as the Subject state (should never fail)
        state = service.getMovies();
        Boolean result = state.isEmpty();
        assertTrue(result);
        System.out.println(TEXT_GREEN + "Test 1 passed" + TEXT_RESET + " Service class constructor is correct");
    }
}
