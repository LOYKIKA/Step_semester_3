class Payment {
    public double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}

class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        double charged = amount + (0.02 * amount);
        System.out.println("Charged (card, incl. fee): Rs " + charged);
        return charged;
    }
}

public class Q5 {
    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cp = (CardPayment) payment;
            return cp.payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100.0, 50.0, 200.0, 75.0, 120.0};
        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}
