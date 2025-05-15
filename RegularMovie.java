public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }
    
    @Override
    public double getPrice(int daysRented) {
        double price = 2;  // 舊片: $2 可以租兩天
        if (daysRented > 2) {
            price += (daysRented - 2) * 1.5;  // 每多一天加 $1.5
        }
        return price;
    }
    
    @Override
    public double getPoints() {
        return 1.0;  // 舊片每租一片可獲得 1.0 常客積點
    }
    
    @Override
    public Movie changeType() {
        // 舊片不會再變化類型
        return this;
    }
    
    @Override
    public String toString() {
        return "舊片: " + getTitle();
    }
}