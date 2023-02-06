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

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {
            double thisAmount = 0;

            //determine amount for each line
            switch (rental.getMovie().getMovieType()) {
                case REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case CHILDREN:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getMovieType() == MovieType.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints ++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;

        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;

    }

    public String htmlStatement(){
        String recup = statement();
        
        return recup ;
    }
}
