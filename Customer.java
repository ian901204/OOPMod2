import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    
    public String getName() {
        return name;
    }
    
    public String statement() {
        double totalPrice = 0;
        double totalPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
        
        for (Rental rental : rentals) {
            double price = rental.getPrice();
            double points = rental.getPoints();
            
            // 加到總額
            totalPrice += price;
            totalPoints += points;
            
            // 印出每筆租借的詳細資訊
            result.append("\t")
                 .append(rental.getMovie().getTitle())
                 .append("\t")
                 .append(rental.getDaysRented())
                 .append(" days\t$")
                 .append(price)
                 .append("\t積點: ")
                 .append(points)
                 .append("\n");
        }
        
        // 加上總金額和總積點的資訊
        result.append("總租金金額為: $").append(totalPrice).append("\n");
        result.append("您獲得的總積點為: ").append(totalPoints).append(" 點");
        
        return result.toString();
    }
}