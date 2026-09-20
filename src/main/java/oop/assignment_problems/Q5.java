import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());
    }
    static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof GroupClassMember) group++;
                else individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}
class GymMember {
    static int enrolled = 0;
    final String membershipNumber;
    int feesPaid = 0;
    public GymMember(int monthlyFee) {
        enrolled++;
        this.membershipNumber = "GYM-200" + enrolled;
    }
    void payFee(int amount) {
        feesPaid += amount;
    }
    void payFee(int amount, String mode) {
        payFee(amount);
    }
    int getFeesPaid() {
        return feesPaid;
    }
    static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }
    static int getMembersEnrolled() {
        return enrolled;
    }
}
class GroupClassMember extends GymMember {
    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
    }
}
