abstract class MembershipPlan {
    abstract int getMonths();
    abstract double getDiscount();

    double calculateFee() {
        return 1000 * getMonths() * (1 - getDiscount());
    }
}

class MonthlyPlan extends MembershipPlan {
    int getMonths() { return 1; }
    double getDiscount() { return 0; }
}

class QuarterlyPlan extends MembershipPlan {
    int getMonths() { return 3; }
    double getDiscount() { return 0.10; }
}

class AnnualPlan extends MembershipPlan {
    int getMonths() { return 12; }
    double getDiscount() { return 0.25; }
}

class Membership {
    String member;
    private String status = "Active";
    MembershipPlan plan;

    Membership(String member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getClass().getSimpleName()
                + " created for " + member);
        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member
                    + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member + "'s membership frozen.");
        } else {
            System.out.println("Cannot freeze a " + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member + "'s membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze a " + status + " membership.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member + "'s membership expired.");
    }

    String getStatus() {
        return status;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Membership asha = new Membership("Asha", new QuarterlyPlan());
        Membership ravi = new Membership("Ravi", new MonthlyPlan());

        asha.checkIn();
        asha.freeze();
        System.out.println("Status: " + asha.getStatus());
        asha.checkIn();

        ravi.expire();
        System.out.println("Status: " + ravi.getStatus());
        ravi.freeze();
    }
}