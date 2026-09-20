import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());
    }
}
class GymMember {
    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;
    protected void chargeLateFee(int amount) {
        if (feeCount < 10) {
            lateFeeHistory[feeCount++] = amount;
        }
    }
    int[] getLateFeeHistory() {
        int[] copy = new int[feeCount];
        for (int i = 0; i < feeCount; i++) {
            copy[i] = lateFeeHistory[i];
        }
        return copy;
    }
    int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < feeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }
}
class PremiumMember extends GymMember {
    String trainerName;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        this.trainerName = trainerName;
    }
    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}
