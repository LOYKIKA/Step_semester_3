import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(members));
    }
    static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (LibraryMember m : members) {
            sb.append(m.displayInfo());
            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m;
                sb.append(" [Course via downcast: ").append(sm.course).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }
}
class LibraryMember {
    public LibraryMember(String memberId, int borrowLimit) {}
    String displayInfo() {
        return "General | Books: 0";
    }
}
class StudentMember extends LibraryMember {
    String course;
    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
    String displayInfo() {
        return "Student | Course: " + course + " | Books: 0";
    }
}
