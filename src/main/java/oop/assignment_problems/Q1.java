import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(classifyAccess("private", "SAME_CLASS"));
    }
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public")) return "ALLOWED";
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }
    static String summarizeByModifier(String[][] attempts) {
        int privAllowed = 0, privDenied = 0;
        int defAllowed = 0, defDenied = 0;
        int protAllowed = 0, protDenied = 0;
        int pubAllowed = 0, pubDenied = 0;
        
        for (int i = 0; i < attempts.length; i++) {
            String mod = attempts[i][0];
            String ctx = attempts[i][1];
            String res = classifyAccess(mod, ctx);
            if (mod.equals("private")) {
                if (res.equals("ALLOWED")) privAllowed++; else privDenied++;
            } else if (mod.equals("default")) {
                if (res.equals("ALLOWED")) defAllowed++; else defDenied++;
            } else if (mod.equals("protected")) {
                if (res.equals("ALLOWED")) protAllowed++; else protDenied++;
            } else if (mod.equals("public")) {
                if (res.equals("ALLOWED")) pubAllowed++; else pubDenied++;
            }
        }
        return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
               "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
               "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
               "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }
}
class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
