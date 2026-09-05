class MembershipCard {
    static String libraryName;
    static String validUntil;
    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }
}

public class Q4 {
    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String name : names) {
            new MembershipCard(name);
            System.out.println("Membership card issued: " + name);
        }
    }
}
