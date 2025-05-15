public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        // Add customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        rentalSystem.addCustomer(customer1);
        rentalSystem.addCustomer(customer2);

        System.out.println("Available movies:");
        for (Movie m : rentalSystem.getAvailableMovies()) {
            System.out.println("- " + m.getTitle() + " (" + m.getClass().getSimpleName() + ")");
        }
        System.out.println("---");

        // Process rentals
        rentalSystem.processRental("Alice", "Avatar: The Way of Water", 3);
        rentalSystem.processRental("Alice", "Toy Story", 5);
        rentalSystem.processRental("Bob", "The Shawshank Redemption", 2);
        rentalSystem.processRental("Bob", "Dune: Part Two", 1);
        rentalSystem.processRental("Bob", "NonExistent Movie", 1); // Test non-existent movie
        rentalSystem.processRental("Charlie", "Toy Story", 1); // Test non-existent customer


        System.out.println("\n--- Reports ---");
        // Generate reports
        String aliceReport = rentalSystem.generateCustomerReport("Alice");
        System.out.println(aliceReport);

        System.out.println("\n---\n");

        String bobReport = rentalSystem.generateCustomerReport("Bob");
        System.out.println(bobReport);
        
        System.out.println("\n---\n");
        String charlieReport = rentalSystem.generateCustomerReport("Charlie"); // Test non-existent customer report
        System.out.println(charlieReport);

        // Direct access example (if needed)
        // Customer foundAlice = rentalSystem.findCustomer("Alice");
        // if (foundAlice != null) {
        //     System.out.println("\nAlice's total frequent renter points: " + foundAlice.getFrequentRenterPointsTotal());
        // }
    }
}