public class Rental {
    private Movie movie;
    private int daysRented;
    // charge and frequentRenterPointsEarned are calculated on demand or at creation
    // For simplicity, we'll calculate them in getters or constructor

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.calculateRentalCost(daysRented);
    }

    public int getFrequentRenterPointsEarned() {
        return movie.calculateFrequentRenterPoints(daysRented);
    }
}