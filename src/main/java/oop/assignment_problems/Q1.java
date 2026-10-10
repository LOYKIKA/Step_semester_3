abstract class WashType {
    abstract int getDuration();
    abstract double getCharge();
}

class QuickWash extends WashType {
    int getDuration() { return 30; }
    double getCharge() { return 20; }
}

class NormalWash extends WashType {
    int getDuration() { return 45; }
    double getCharge() { return 30; }
}

class HeavyWash extends WashType {
    int getDuration() { return 60; }
    double getCharge() { return 45; }
}

class WashingMachine {
    String id;
    private boolean busy = false;

    WashingMachine(String id) {
        this.id = id;
    }

    boolean isFree() {
        return !busy;
    }

    boolean startWash(String student, WashType wash) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return false;
        }

        busy = true;
        System.out.println(wash.getClass().getSimpleName()
                + " started on " + id + " for " + student
                + " (" + wash.getDuration() + " min).");
        System.out.printf("Charge: ₹%.2f%n", wash.getCharge());
        return true;
    }

    void completeWash() {
        if (busy) {
            busy = false;
            System.out.println(id + " cycle completed. " + id + " is now free.");
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash("Asha", new QuickWash());
        m1.startWash("Ravi", new HeavyWash());
        m2.startWash("Ravi", new HeavyWash());

        m1.completeWash();
        m1.startWash("Neha", new NormalWash());
    }
}