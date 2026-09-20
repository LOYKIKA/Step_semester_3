import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(processNightlyCirculation(receipts));
    }
    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int refOnly = 0;
        int regular = 0;
        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipts[i] instanceof ReferenceOnlyLoanReceipt) {
                    refOnly++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + refOnly + " reference-only | " + regular + " regular";
    }
}
class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = new String[bookIds.length];
        for (int i = 0; i < bookIds.length; i++) {
            this.bookIds[i] = bookIds[i];
        }
    }
    public String[] getBookIds() {
        String[] copy = new String[bookIds.length];
        for (int i = 0; i < bookIds.length; i++) {
            copy[i] = bookIds[i];
        }
        return copy;
    }
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = getBookIds();
        if (index >= 0 && index < newIds.length) {
            newIds[index] = newId;
        }
        return new LoanReceipt(this.memberId, newIds);
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}
class CirculationLedger {
    static String branchCode;
    static {
        branchCode = "BR-01";
    }
}
