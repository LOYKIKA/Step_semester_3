import java.time.*;
import java.util.*;

abstract class Room {
    int number;
    double price;

    Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    abstract double calculatePrice(long days);
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number, 100);
    }

    double calculatePrice(long days) {
        return price * days;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number, 200);
    }

    double calculatePrice(long days) {
        return price * days;
    }
}

class Reservation {
    Room room;
    String customer;
    LocalDate start, end;
    boolean active = true;

    Reservation(Room room, String customer,
                LocalDate start, LocalDate end) {
        this.room = room;
        this.customer = customer;
        this.start = start;
        this.end = end;
    }

    boolean overlaps(LocalDate s, LocalDate e) {
        return active && start.isBefore(e) && s.isBefore(end);
    }

    void cancel() {
        if (LocalDate.now().isBefore(start)) {
            active = false;
            System.out.println("Reservation cancelled");
        } else {
            System.out.println("Cancellation deadline passed");
        }
    }
}

public class Q4 {
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Room room = new StandardRoom(101);

        LocalDate start = LocalDate.of(2027, 1, 1);
        LocalDate end = LocalDate.of(2027, 1, 5);

        book(room, "Customer A", start, end);
        book(room, "Customer B",
             LocalDate.of(2027, 1, 3),
             LocalDate.of(2027, 1, 7));

        reservations.get(0).cancel();
    }

    static void book(Room room, String customer,
                     LocalDate start, LocalDate end) {
        for (Reservation r : reservations) {
            if (r.room.number == room.number &&
                r.overlaps(start, end)) {
                System.out.println("Room is unavailable");
                return;
            }
        }

        if (!start.isBefore(end)) {
            System.out.println("Invalid reservation dates");
            return;
        }

        Reservation r = new Reservation(room, customer, start, end);
        reservations.add(r);

        long days = java.time.temporal.ChronoUnit.DAYS
                .between(start, end);

        System.out.println("Reservation confirmed for " + customer);
        System.out.println("Price: $" + room.calculatePrice(days));
    }
}