import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());
    }
}
class LibraryMember {
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    protected void chargeFine(int amount) {
        if (fineCount < 10) {
            fineHistory[fineCount++] = amount;
        }
    }
    int[] getFineHistory() {
        int[] copy = new int[fineCount];
        for (int i = 0; i < fineCount; i++) {
            copy[i] = fineHistory[i];
        }
        return copy;
    }
    int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }
}
class StudentMember extends LibraryMember {
    String course;
    public StudentMember(String memberId, int borrowLimit, String course) {
        this.course = course;
    }
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}
