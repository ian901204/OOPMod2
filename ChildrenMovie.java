public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }
    
    @Override
    public double getPrice(int daysRented) {
        double price = 1.5;  // 兒童片: $1.5 可以租三天
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;  // 每多一天加 $1.5
        }
        return price;
    }
    
    @Override
    public double getPoints() {
        return 0.5;  // 兒童片每租一片可獲得 0.5 常客積點
    }
    
    @Override
    public Movie changeType() {
        // 兒童片不會變化類型
        return this;
    }
    
    @Override
    public String toString() {
        return "兒童片: " + getTitle();
    }
}