import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

public class CustomerTest {

    @Test
    void testStatementRegular(){
        Movie movie1 = new Movie("Jaws", MovieType.REGULAR);
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie1, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie1.getTitle() + "\t8.0\n" +
                "Amount owed is 8.0\nYou earned 1 frequent renter points";

        assertEquals(expected, client.statement());
    }

    @Test
    void testStatementNewRelease(){
        Movie movie1 = new Movie("Jaws", MovieType.NEW_RELEASE);
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie1, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie1.getTitle() + "\t18.0\n" +
                        "Amount owed is 18.0\nYou earned 2 frequent renter points";

        assertEquals(expected, client.statement());
    }

    @Test
    void testStatementChildren(){
        Movie movie1 = new Movie("Jaws", MovieType.CHILDREN);
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie1, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie1.getTitle() + "\t6.0\n" +
                        "Amount owed is 6.0\nYou earned 1 frequent renter points";

        assertEquals(expected, client.statement());
    }

}
