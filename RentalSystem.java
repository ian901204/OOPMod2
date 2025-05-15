import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalSystem {
    private List<Customer> customers = new ArrayList<>();
    private List<Movie> availableMovies = new ArrayList<>(); // Optional, as per UML

    public RentalSystem() {
        // Initialize with some movies if desired
        availableMovies.add(new RegularMovie("The Shawshank Redemption"));
        availableMovies.add(new NewReleaseMovie("Avatar: The Way of Water"));
        availableMovies.add(new ChildrensMovie("Toy Story"));
        availableMovies.add(new RegularMovie("The Godfather"));
        availableMovies.add(new NewReleaseMovie("Dune: Part Two"));
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null; // Or throw an exception
    }

    public Optional<Movie> findMovie(String title) {
        for (Movie movie : availableMovies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }
    
    public void addMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public void processRental(String customerName, String movieTitle, int daysRented) {
        Customer customer = findCustomer(customerName);
        Optional<Movie> movieOpt = findMovie(movieTitle);

        if (customer == null) {
            System.out.println("Error: Customer " + customerName + " not found.");
            return;
        }
        if (movieOpt.isEmpty()) {
            System.out.println("Error: Movie " + movieTitle + " not found.");
            return;
        }

        Movie movie = movieOpt.get();
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        System.out.println("Rental processed for " + customerName + ": " + movie.getTitle() + " for " + daysRented + " days.");
    }

    public String generateCustomerReport(String customerName) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            return customer.generateRentalReport();
        }
        return "Customer " + customerName + " not found.";
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }
}