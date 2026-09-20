import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
class MessWallet {
    private double balance;
    public MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative balance given. Starting at 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
        } else {
            this.balance += amount;
        }
    }
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }
    public double getBalance() {
        return this.balance;
    }
}
