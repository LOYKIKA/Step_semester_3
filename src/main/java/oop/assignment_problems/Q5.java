import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Payment[] payments = new Payment[5];
        payments[0] = new CardPayment();
        payments[1] = new Payment();
        payments[2] = new CardPayment();
        payments[3] = new Payment();
        payments[4] = new CardPayment();
        
        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0;
        
        Q5 processor = new Q5();
        for (int i = 0; i < payments.length; i++) {
            totalCollected += processor.processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + totalCollected);
    }
    public double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cp = (CardPayment) payment;
            return cp.payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }
}
class Payment {
    public double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}
class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}
