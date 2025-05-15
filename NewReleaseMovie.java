public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }
    
    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;  // 新片: $3/天
    }
    
    @Override
    public double getPoints() {
        return 2.0;  // 新片每租一片可獲得 2.0 常客積點
    }
    
    @Override
    public Movie changeType() {
        // 新片變成舊片
        return new RegularMovie(getTitle());
    }
    
    @Override
    public String toString() {
        return "新片: " + getTitle();
    }
}