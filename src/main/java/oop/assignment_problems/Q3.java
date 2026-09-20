import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory b = new BookInventory(3);
        b.checkOut(); b.checkOut(); b.checkOut();
        b.checkOut();
        System.out.println(b.getCopiesAvailable());
    }
}
class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;
    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }
    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }
    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }
    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}
