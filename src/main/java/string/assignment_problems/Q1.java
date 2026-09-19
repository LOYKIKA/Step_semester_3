import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seats = new int[n];
        for(int i=0; i<n; i++) {
            seats[i] = sc.nextInt();
        }
        checkDuplicateSeats(seats);
    }
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for(int i=0; i<seatNumbers.length; i++) {
            boolean alreadyPrinted = false;
            for(int k=0; k<i; k++) {
                if(seatNumbers[k] == seatNumbers[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if(alreadyPrinted) continue;
            
            for(int j=i+1; j<seatNumbers.length; j++) {
                if(seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }
        if(!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
