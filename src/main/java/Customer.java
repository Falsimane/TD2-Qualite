import java.util.Vector;

// Thomas Falsimagne / Leila Martinet - Groupe 3B

public class Customer {
    private final String _name;
    private final Vector<Rental> _rentals;

    public Customer(String name) {
        this._name = name;
        this._rentals = new Vector<>();
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /**
     * Return customer's statement
     * @return
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {

            double thisAmount = rental.getMovie().statement(rental.getDaysRented());

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rental.getMovie() instanceof NewReleaseMovie) && rental.getDaysRented() > 1)
                frequentRenterPoints ++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;

        }
        // add footer lines
        result += "Amount owned is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;

    }

    /**
     * Return a string of customer's statement in html format
     * @return
     */
    public String htmlStatement(){

        String sentences [] = statement().split("\n");
        String htmlString = "";
        for (int i=0; i<sentences.length; i++)
        {
            if (i==0)
            {
                htmlString += "<h1>" + sentences[i] + "<h1>\n<p>\n\t<ul>\n";
            }
            else if (i==sentences.length - 2)
            {
                if (sentences.length <= 3)
                {
                    htmlString += "\t\tNo rental record for " + this._name + "\n";
                }
                htmlString += "\t</ul>\n</p>\n<p>\n\t<em>\n\t\t" + sentences[i] + "<br>\n";
            }
            else if (i==sentences.length - 1)
            {
                htmlString += "\t\t" + sentences[i] + "<br>\n\t</em>\n</p>";
            }
            else
            {
                htmlString += "\t\t<li>" + sentences[i] + "</li>\n";
            }
        }
        return htmlString;
    }
}
