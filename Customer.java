import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    // frequentRenterPointsTotal is calculated

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int getFrequentRenterPointsTotal() {
        int totalPoints = 0;
        for (Rental rental : rentals) {
            totalPoints += rental.getFrequentRenterPointsEarned();
        }
        return totalPoints;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : rentals) {
            double thisAmount = each.getCharge();
            frequentRenterPoints += each.getFrequentRenterPointsEarned();

            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    // generateRentalReport can be similar to statement or more detailed
    // For this example, it will be the same as statement()
    public String generateRentalReport() {
        return statement();
    }
}