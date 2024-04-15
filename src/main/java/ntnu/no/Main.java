package ntnu.no;

import ntnu.no.booking.MovieTicketServer;
import ntnu.no.booking.MovieTicketClient;

public class Main {
    public static void main(String[] args) {
        MovieTicketServer movieTicketServer = new MovieTicketServer("Demo Movie", 10);

        Thread t1 = new MovieTicketClient(movieTicketServer, "Hans", 3);
        Thread t2 = new MovieTicketClient(movieTicketServer, "Ole", 3);
        Thread t3 = new MovieTicketClient(movieTicketServer, "Petter", 3);
        Thread t4 = new MovieTicketClient(movieTicketServer, "Fredrik", 3);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        long startTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        long endTime = System.currentTimeMillis();

        System.out.println("time: " + (endTime - startTime) + " milliseconds");
    }
}