public abstract class Movie {
    private String title;
    
    public Movie(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    // 使用抽象方法，讓子類別實作自己的計價邏輯
    public abstract double getPrice(int daysRented);
    
    // 使用抽象方法，讓子類別實作自己的積點計算邏輯
    public abstract double getPoints();
    
    // 電影類型轉換的抽象方法
    public abstract Movie changeType();
}