import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String typed = sc.nextLine();
        checkTypingAccuracy(original, typed);
    }
    public static void checkTypingAccuracy(String original, String typed) {
        int match = 0;
        int firstMismatch = -1;
        for(int i=0; i<original.length(); i++) {
            if(original.charAt(i) == typed.charAt(i)) {
                match++;
            } else {
                if(firstMismatch == -1) {
                    firstMismatch = i;
                }
            }
        }
        double acc = (match * 100.0) / original.length();
        if(firstMismatch == -1) {
            System.out.println("Matched: " + match + "/" + original.length() + " | Accuracy: " + String.format("%.2f", acc) + "% | No Mismatches");
        } else {
            System.out.println("Matched: " + match + "/" + original.length() + " | Accuracy: " + String.format("%.2f", acc) + "% | First Mismatch at position " + firstMismatch + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }
}
