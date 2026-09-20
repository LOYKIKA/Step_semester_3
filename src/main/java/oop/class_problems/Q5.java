import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student("Alice", 90);
        Student s2 = new Student("Bob", 85);
        Student.printCollegeInfo();
    }
}
class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;
    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
