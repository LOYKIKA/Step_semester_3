import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String log = sc.next();
        findLongestStreak(log);
    }
    public static void findLongestStreak(String signalLog) {
        if(signalLog.isEmpty()) return;
        int maxLen = 0;
        char maxChar = ' ';
        int curLen = 1;
        char curChar = signalLog.charAt(0);
        for(int i=1; i<signalLog.length(); i++) {
            if(signalLog.charAt(i) == curChar) {
                curLen++;
            } else {
                if(curLen > maxLen) {
                    maxLen = curLen;
                    maxChar = curChar;
                }
                curChar = signalLog.charAt(i);
                curLen = 1;
            }
        }
        if(curLen > maxLen) {
            maxLen = curLen;
            maxChar = curChar;
        }
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxLen + " times");
    }
}
