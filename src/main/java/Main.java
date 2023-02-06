public class Main {


    public static void main(String[] args) {

    Customer aCustomer = new Customer("BILL");

        aCustomer.addRental(new Rental(new Movie("Back To The Future", MovieType.REGULAR), 5));
        System.out.println(aCustomer.statement());
    }
}
