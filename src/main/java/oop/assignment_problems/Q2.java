import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        GymMember[] members = {
            new PremiumMember("MEM2", 2000, "Coach Riya"),
            new EliteMember("MEM3", 3000, "Coach Arjun", "L12"),
            new GroupClassMember("MEM4", 1500, "Zumba")
        };
        ((PremiumMember)members[0]).attendSession();
        ((PremiumMember)members[0]).attendSession();
        ((PremiumMember)members[0]).attendSession();
        ((EliteMember)members[1]).attendSession();
        ((EliteMember)members[1]).attendSession();
        ((GroupClassMember)members[2]).attendSession();
        ((GroupClassMember)members[2]).attendSession();
        ((GroupClassMember)members[2]).attendSession();
        ((GroupClassMember)members[2]).attendSession();
        
        System.out.println(getTotalSessionsAttended(members));
    }
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof GroupClassMember) return "Hierarchical sibling (independent branch)";
        return "Unknown";
    }
    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember m : members) {
            total += m.getSessionsAttended();
        }
        return total;
    }
}
class GymMember {
    String memberId;
    int monthlyFee;
    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    int getSessionsAttended() { return 0; }
    String displayInfo() {
        return "Standard Member | Sessions: " + getSessionsAttended();
    }
}
class PremiumMember extends GymMember {
    String trainerName;
    int sessionsAttended = 0;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    void attendSession() { sessionsAttended++; }
    int getSessionsAttended() { return sessionsAttended; }
    String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}
class EliteMember extends PremiumMember {
    String lockerNumber;
    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }
    String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
    }
}
class GroupClassMember extends GymMember {
    String className;
    int sessionsAttended = 0;
    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }
    void attendSession() { sessionsAttended++; }
    int getSessionsAttended() { return sessionsAttended; }
    String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }
}
