public class Movie {

    private String _title;
    private MovieType _movieType;

    public Movie (String title, MovieType movieType) {
        this._title = title;
        this._movieType = movieType;
    }

    public MovieType getMovieType() {
        return _movieType;
    }

    public String getTitle() {
        return _title;
    }
}
