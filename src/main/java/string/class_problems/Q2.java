import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        parseStudentRecord(line);
    }
    public static void parseStudentRecord(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + parts[0] + " | Roll No: " + parts[1] + " | Dept: " + parts[2]);
        }
    }
}
