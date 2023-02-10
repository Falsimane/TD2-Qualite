public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double statement(int daysRented) {
        int amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }


}
