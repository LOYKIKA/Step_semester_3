import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};
        
        for (int i = 0; i < regNos.length; i++) {
            if (daysLate[i] <= 0) {
                System.out.println(regNos[i] + " - On time, no late fee");
            } else {
                LateFeeAccount acc = new LateFeeAccount(regNos[i], totalFees[i]);
                acc.printSummary(daysLate[i]);
            }
        }
    }
}
class LateFeeAccount {
    String regNo;
    double totalFee;
    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }
    public final double calculateLateFee(int daysLate) {
        return (daysLate / 100.0) * totalFee;
    }
    public final void printSummary(int daysLate) {
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate));
    }
}
