import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("STU2", 3, "CSE"),
            new HonorsStudentMember("STU3", 3, "ECE", 2),
            new FacultyMember("STU4", 5, "Physics")
        };
        ((StudentMember)members[0]).borrowBook();
        ((StudentMember)members[0]).borrowBook();
        ((HonorsStudentMember)members[1]).borrowBook();
        ((FacultyMember)members[2]).borrowBook();
        ((FacultyMember)members[2]).borrowBook();
        ((FacultyMember)members[2]).borrowBook();
        System.out.println(getTotalBooksBorrowed(members));
    }
    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof FacultyMember) return "Hierarchical sibling (independent branch)";
        return "Unknown";
    }
    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) {
            total += m.getBooksBorrowed();
        }
        return total;
    }
}
class LibraryMember {
    String memberId;
    int borrowLimit;
    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }
    int getBooksBorrowed() { return 0; }
    String displayInfo() {
        return "General Member | Books Borrowed: " + getBooksBorrowed();
    }
}
class StudentMember extends LibraryMember {
    String course;
    int booksBorrowed = 0;
    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
    void borrowBook() { booksBorrowed++; }
    int getBooksBorrowed() { return booksBorrowed; }
    String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}
class HonorsStudentMember extends StudentMember {
    int bonusLimit;
    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }
    String displayInfo() {
        return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed();
    }
}
class FacultyMember extends LibraryMember {
    String department;
    int booksBorrowed = 0;
    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }
    void borrowBook() { booksBorrowed++; }
    int getBooksBorrowed() { return booksBorrowed; }
    String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}
