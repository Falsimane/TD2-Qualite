public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double statement(int daysRented) {
        return daysRented * 3;
    }
}
