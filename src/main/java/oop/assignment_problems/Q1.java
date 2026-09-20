import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(signUpBatch(ids, 1000));
    }
    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}
class GymMember {
    String memberId;
    int monthlyFee;
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    void attendSession() {}
    int getSessionsAttended() { return 0; }
}
class PremiumMember extends GymMember {
    String trainerName;
    int sessionsAttended = 0;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    void attendSession() {
        sessionsAttended++;
    }
    int getSessionsAttended() {
        return sessionsAttended;
    }
}
