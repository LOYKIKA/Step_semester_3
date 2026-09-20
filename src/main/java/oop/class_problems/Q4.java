import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (int i = 0; i < names.length; i++) {
            SrmStudent s = new SrmStudent(names[i]);
            System.out.println("Student record created: " + names[i]);
        }
    }
}
class SrmStudent {
    static String collegeName;
    static String academicYear;
    String name;
    static {
        collegeName = "SRM";
        academicYear = "2024";
        System.out.println("College info loaded");
    }
    public SrmStudent(String name) {
        this.name = name;
    }
}
