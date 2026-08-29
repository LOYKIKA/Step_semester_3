public class Q5 {
    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");
        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortWords, mediumWords, longWords);
    }
}