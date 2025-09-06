import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create some sample movies
        Movie[] movies = new Movie[]{
                new Movie("Avatar: The Way of Water", "3 hours 10 minutes", "English", 100),
                new Movie("Mission: Impossible – Dead Reckoning", "2 hours 45 minutes", "English", 50),
                new Movie("Spider-Man: Across the Spider-Verse", "2 hours 20 minutes", "English", 75)
        };

        // Create a HashMap to store Ticket objects by Ticket ID
        HashMap<Integer, Ticket> tickets = new HashMap<>();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Simulate booking tickets (For example)
        tickets.put(101, new Ticket(101, "Avatar: The Way of Water", 15, "Regular", 200));
        tickets.put(102, new Ticket(102, "Mission: Impossible – Dead Reckoning", 5, "Premium", 300));

        // Display all available movies
        System.out.println("Select a movie to cancel a ticket:");
        for (int i = 0; i < movies.length; i++) {
            movies[i].displayMovie();
        }

        // Let the user input the Ticket ID to cancel
        System.out.print("Enter the Ticket ID to cancel: ");
        int ticketID = scanner.nextInt();

        // Check if the ticket exists
        if (!tickets.containsKey(ticketID)) {
            System.out.println("Invalid Ticket ID. No such ticket found.");
            return;
        }

        // Get the ticket object
        Ticket ticket = tickets.get(ticketID);

        // If the ticket is already cancelled, exit
        if (ticket.isCancelled()) {
            System.out.println("This ticket has already been cancelled.");
            return;
        }

        // Display ticket details before cancellation
        ticket.displayTicket();

        // Confirm the cancellation
        System.out.print("Are you sure you want to cancel this ticket? (yes/no): ");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("yes")) {
            // Cancel the ticket
            ticket.cancelTicket();

            // Refund amount based on seat type
            double refundAmount = ticket.getSeatType().equalsIgnoreCase("Regular") ? 200 : 300;
            System.out.println("Refund Amount: $" + refundAmount);

            // Find the movie and update available seats and revenue
            for (Movie movie : movies) {
                if (movie.getMovieName().equals(ticket.getMovieName())) {
                    movie.increaseAvailableSeats();
                    movie.decreaseRevenue(refundAmount);
                    break;
                }
            }

            // Display updated revenue for the movie
            System.out.println("Updated Movie Revenue: $" + movies[0].getTotalRevenue());
        } else {
            System.out.println("Ticket cancellation aborted.");
        }

        scanner.close();
    }
}
