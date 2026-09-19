import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char c = findFirstNonRepeatingChar(text);
        if(c != '\0') {
            System.out.println("First Non-Repeating Character: '" + c + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256];
        for(int i=0; i<text.length(); i++) {
            counts[text.charAt(i)]++;
        }
        for(int i=0; i<text.length(); i++) {
            if(counts[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}
