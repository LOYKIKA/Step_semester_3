import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);
    }
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int groups = 0;
        int individuals = 0;
        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipts[i] instanceof GroupBookingReceipt) {
                    groups++;
                } else {
                    individuals++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + groups + " group | " + individuals + " individual";
    }
}
class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = new String[seatNumbers.length];
        for (int i = 0; i < seatNumbers.length; i++) {
            this.seatNumbers[i] = seatNumbers[i];
        }
    }
    public String[] getSeatNumbers() {
        String[] copy = new String[seatNumbers.length];
        for (int i = 0; i < seatNumbers.length; i++) {
            copy[i] = seatNumbers[i];
        }
        return copy;
    }
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] newSeats = getSeatNumbers();
        if (index >= 0 && index < newSeats.length) {
            newSeats[index] = newSeat;
        }
        return new BookingReceipt(this.bookingId, newSeats);
    }
}
class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;
    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}
