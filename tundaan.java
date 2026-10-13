import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    public Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }
}

public class dagunlay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Ticket> queue = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine();

        // Input tickets
        for (int i = 1; i <= numberOfTickets; i++) {
            System.out.println("\nTicket " + i);

            System.out.print("Enter ticket name: ");
            String name = scanner.nextLine();

            System.out.print("Enter urgency (lower number = higher priority): ");
            int urgency = scanner.nextInt();
            scanner.nextLine();

            queue.offer(new Ticket(name, urgency, i));
        }

        System.out.println("\nHelp-Desk Ticket Queue:");

        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll();

            System.out.println(
                ticket.name + " (Urgency: " + ticket.urgency + ")"
            );
        }

        scanner.close();
    }
}
