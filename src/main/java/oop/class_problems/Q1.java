import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(ids, 3));
    }
    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}
class LibraryMember {
    String memberId;
    int borrowLimit;
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }
    void borrowBook() {}
    int getBooksBorrowed() { return 0; }
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
}
