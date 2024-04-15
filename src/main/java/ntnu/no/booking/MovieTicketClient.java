package ntnu.no.booking;

public class MovieTicketClient extends Thread {
    private String customerName;
    private int numberOfTickets;
    private MovieTicketServer server;

    public MovieTicketClient(MovieTicketServer server, String customerName, int numberOfTickets) {
        this.server = server;
        this.customerName = customerName;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
public void run() {
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    server.bookTicket(customerName, numberOfTickets);
}
}