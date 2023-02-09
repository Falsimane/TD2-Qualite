public abstract class Movie {

    private String _title;

    public Movie (String title) {
        this._title = title;
    }

    public String getTitle() {
        return _title;
    }

    /**
     * Return the movie statement according to the number of days rented
     * @param daysRented the number of days the movie has been rented
     * @return
     */
    public abstract double statement (int daysRented);
}
