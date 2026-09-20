import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(members));
    }
    static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (GymMember m : members) {
            sb.append(m.displayInfo());
            if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m;
                sb.append(" [Trainer via downcast: ").append(pm.trainerName).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }
}
class GymMember {
    public GymMember(String memberId, int monthlyFee) {}
    String displayInfo() {
        return "Standard | Sessions: 0";
    }
}
class PremiumMember extends GymMember {
    String trainerName;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: 0";
    }
}
