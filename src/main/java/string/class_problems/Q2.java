import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        boolean iter = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean arr = isPalindromeArrayReversal(text);
        String iStr = iter ? "Palindrome" : "Not Palindrome";
        String rStr = rec ? "Palindrome" : "Not Palindrome";
        String aStr = arr ? "Palindrome" : "Not Palindrome";
        System.out.println("Iterative: " + iStr + " | Recursive: " + rStr + " | Array Reversal: " + aStr);
    }
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while(left < right) {
            if(text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text) {
        if(text.length() <= 1) return true;
        if(text.charAt(0) != text.charAt(text.length()-1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length()-1));
    }
    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int n = arr.length;
        char[] rev = new char[n];
        for(int i=0; i<n; i++) {
            rev[i] = arr[n-1-i];
        }
        String revStr = new String(rev);
        return text.equals(revStr);
    }
}
