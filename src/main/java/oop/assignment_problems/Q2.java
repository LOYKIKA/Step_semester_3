import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}
class PayrollAccount {
    private double basicSalary;
    private double bonus;
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
    }
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax percent must be between 0 and 100");
        } else {
            this.basicSalary -= this.basicSalary * (percent / 100.0);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }
    public double getNetSalary() {
        return basicSalary + bonus;
    }
}
