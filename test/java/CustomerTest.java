import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void testStatementRegular(){
        Movie movie1 = new RegularMovie("Jaws");
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie1, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie1.getTitle() + "\t8.0\n" +
                "Amount owned is 8.0\nYou earned 1 frequent renter points";

        assertEquals(expected, client.statement());
    }

    @Test
    void testStatementNewRelease(){
        Movie movie1 = new NewReleaseMovie("Scream");
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie1, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie1.getTitle() + "\t18.0\n" +
                        "Amount owned is 18.0\nYou earned 2 frequent renter points";

        assertEquals(expected, client.statement());
    }

    @Test
    void testStatementChildren(){
        Movie movie = new ChildrenMovie("The Goonies");
        Customer client = new Customer("Falsimagne");
        client.addRental(new Rental(movie, 6));
        String expected =
                "Rental Record for " + client.getName() + "\n" +
                        "\t" + movie.getTitle() + "\t6.0\n" +
                        "Amount owned is 6.0\nYou earned 1 frequent renter points";

        assertEquals(expected, client.statement());
    }

    @Test
    void testStatementHtml()
    {
        Movie movie = new RegularMovie("Breakfast Club");
        Customer client = new Customer("Martinet");
        client.addRental(new Rental(movie, 13));
        String expected =
                "<h1>Rental Record for Martinet<h1>\n" +
                        "<p>\n\t<ul>\n\t\t<li>" +
                        "\tBreakfast Club\t18.0" +
                        "</li>\n\t</ul>\n</p>\n" +
                        "<p>\n\t<em>\n" +
                        "\t\tAmount owned is 18.0<br>\n" +
                        "\t\tYou earned 1 frequent renter points<br>\n" +
                        "\t</em>\n</p>";

        assertEquals(expected, client.htmlStatement());
    }

    @Test
    void testStatementHtmlNoRental()
    {
        Customer client = new Customer("Martinet");
        String expected =
                "<h1>Rental Record for Martinet<h1>\n" +
                        "<p>\n\t<ul>\n" +
                        "\t\tNo rental record for Martinet\n" +
                        "\t</ul>\n</p>\n" +
                        "<p>\n\t<em>\n" +
                        "\t\tAmount owned is 0.0<br>\n" +
                        "\t\tYou earned 0 frequent renter points<br>\n" +
                        "\t</em>\n</p>";

        assertEquals(expected, client.htmlStatement());
    }
}
