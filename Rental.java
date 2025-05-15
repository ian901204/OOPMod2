public class Rental {
    private Movie movie;
    private int daysRented;
    
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
    
    // 計算此筆租借的費用
    public double getPrice() {
        return movie.getPrice(daysRented);
    }
    
    // 計算此筆租借的積點
    public double getPoints() {
        return movie.getPoints();
    }
}