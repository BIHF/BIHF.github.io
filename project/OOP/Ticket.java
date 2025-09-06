public class Ticket {
    private int ticketID;
    private String movieName;
    private int seatNumber;
    private String seatType;
    private double price;
    private boolean isCancelled;

    // Constructor
    public Ticket(int ticketID, String movieName, int seatNumber, String seatType, double price) {
        this.ticketID = ticketID;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.isCancelled = false; // Initially, the ticket is not cancelled
    }

    // Getter method for isCancelled
    public boolean isCancelled() {
        return isCancelled;
    }

    // Getter method for movieName
    public String getMovieName() {
        return movieName;
    }

    public String getSeatType() {
        return seatType;
    }

    public double getPrice() {
        return price;
    }

    // Method to cancel the ticket
    public void cancelTicket() {
        if (!isCancelled) {
            this.isCancelled = true;
        } else {
            System.out.println("This ticket has already been cancelled.");
        }
    }

    // Method to display ticket details
    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Seat Type: " + seatType);
        System.out.println("Price: $" + price);
        System.out.println("-----------------------------");
    }
}
