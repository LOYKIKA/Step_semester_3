import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        FeeAccount[] accounts = new FeeAccount[4];
        accounts[0] = new HostelFeeAccount();
        accounts[1] = new HostelFeeAccount();
        accounts[2] = new FeeAccount();
        accounts[3] = new FeeAccount();
        
        int hostelCount = 0;
        int dayScholarCount = 0;
        
        Q5 processor = new Q5();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
            processor.processPayment(accounts[i], 60000);
        }
        
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
    
    public void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
        } else {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }
}
class FeeAccount {}
class HostelFeeAccount extends FeeAccount {}
