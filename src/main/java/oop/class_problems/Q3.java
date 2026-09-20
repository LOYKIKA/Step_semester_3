import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CineScreen c = new CineScreen(2);
        c.bookSeat(); c.bookSeat(); c.bookSeat();
        System.out.println(c.getSeatsAvailable());
    }
}
class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;
    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            System.out.println("construction rejected");
            this.seatsTotal = 1;
            this.seatsAvailable = 1;
        } else {
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }
    }
    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }
    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
