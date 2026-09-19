import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String review = sc.nextLine();
        classifyWordLengths(review);
    }
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int s = 0;
        int m = 0;
        int l = 0;
        for(String w : words) {
            int len = w.length();
            if(len >= 1 && len <= 4) s++;
            else if(len >= 5 && len <= 8) m++;
            else if(len >= 9) l++;
        }
        System.out.println("Short: " + s + " | Medium: " + m + " | Long: " + l);
    }
}
