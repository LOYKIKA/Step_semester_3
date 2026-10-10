import java.time.LocalDateTime;
import java.util.*;

abstract class Seat {
    String number;

    Seat(String number) {
        this.number = number;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String number) {
        super(number);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String number) {
        super(number);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String number) {
        super(number);
    }

    double getPrice() {
        return 400;
    }
}

class Show {
    String name;
    LocalDateTime startTime;
    Set<String> bookedSeats = new HashSet<>();

    Show(String name, LocalDateTime startTime) {
        this.name = name;
        this.startTime = startTime;
    }
}

class Booking {
    String customer;
    Show show;
    List<Seat> seats;
    boolean active = true;

    Booking(String customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(seats);
    }

    double total() {
        double amount = 0;
        for (Seat seat : seats) {
            amount += seat.getPrice();
        }
        return amount;
    }

    void cancel() {
        if (!active) {
            System.out.println("Booking already cancelled.");
            return;
        }

        if (!LocalDateTime.now().isBefore(show.startTime)) {
            System.out.println("Cannot cancel after the show starts.");
            return;
        }

        for (Seat seat : seats) {
            show.bookedSeats.remove(seat.number);
        }

        active = false;
        System.out.println(customer + "'s booking cancelled.");
    }
}

public class Q3 {
    static Booking book(String customer, Show show, Seat... seats) {
        if (seats.length == 0 || seats.length > 6) {
            System.out.println("Select 1 to 6 seats.");
            return null;
        }

        Set<String> requested = new HashSet<>();

        for (Seat seat : seats) {
            if (!requested.add(seat.number)
                    || show.bookedSeats.contains(seat.number)) {
                System.out.println("Seat " + seat.number
                        + " is already booked for this show.");
                return null;
            }
        }

        show.bookedSeats.addAll(requested);

        Booking booking = new Booking(
                customer, show, Arrays.asList(seats));

        System.out.print("Booking confirmed for " + customer + ": ");
        for (Seat seat : seats) {
            System.out.print(seat.number + " ");
        }

        System.out.printf("%nTotal: ₹%.2f%n", booking.total());
        return booking;
    }

    public static void main(String[] args) {
        Show show = new Show("7 PM Show",
                LocalDateTime.now().plusHours(2));

        Booking asha = book("Asha", show,
                new RegularSeat("A1"),
                new RegularSeat("A2"),
                new PremiumSeat("F5"));

        book("Ravi", show, new RegularSeat("A2"));
        book("Ravi", show, new ReclinerSeat("R1"));

        if (asha != null) {
            asha.cancel();
        }

        book("Neha", show, new RegularSeat("A2"));
    }
}