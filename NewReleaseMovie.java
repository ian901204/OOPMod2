// filepath: NewReleaseMovie.java
public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateRentalCost(int daysRented) {
        return daysRented * 3.0;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}