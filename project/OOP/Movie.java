public class Movie {
    private String movieName;
    private String duration;
    private String language;
    private int totalSeats;
    private int availableSeats;
    private double totalRevenue;
    public Movie(String movieName, String duration, String language, int totalSeats) {
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.totalRevenue = 0.0;
    }
    public String getMovieName() {
        return movieName;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public double getTotalRevenue() {
        return totalRevenue;
    }
    public void reduceAvailableSeats() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            System.out.println("No available seats left for this movie.");
        }
    }
    public void increaseAvailableSeats() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        } else {
            System.out.println("All seats are already available.");
        }
    }
    public void increaseRevenue(double amount) {
        totalRevenue += amount;
    }
    public void decreaseRevenue(double amount) {
        totalRevenue -= amount;
    }
    public void displayMovie() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Duration: " + duration);
        System.out.println("Language: " + language);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("----------------------------");
    }
}
