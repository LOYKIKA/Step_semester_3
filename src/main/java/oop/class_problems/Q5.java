import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());
    }
    static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;
        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) faculty++;
                else regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}
class LibraryMember {
    static int enrolled = 0;
    final String memberNumber;
    int booksBorrowed = 0;
    public LibraryMember(int borrowLimit) {
        enrolled++;
        this.memberNumber = "LIB-" + (100 + enrolled);
    }
    void borrowBook() {
        booksBorrowed++;
    }
    void borrowBook(String genre) {
        borrowBook();
    }
    int getBooksBorrowed() {
        return booksBorrowed;
    }
    static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'R') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }
    static int getMembersEnrolled() {
        return enrolled;
    }
}
class FacultyMember extends LibraryMember {
    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
    }
}
