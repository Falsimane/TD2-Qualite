public class Main {

    public static void main(String[] args) {

    Customer aCustomer = new Customer("BILL");

        aCustomer.addRental(new Rental(new RegularMovie("Back To The Future"), 5));
        System.out.println(aCustomer.statement());
    }
}
