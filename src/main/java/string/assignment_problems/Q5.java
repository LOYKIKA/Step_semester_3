import java.util.Scanner;
import java.util.HashMap;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
    }
    public static void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "").replace(",", "");
        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            if (w.isEmpty()) continue;
            if (w.equals("the") || w.equals("was") || w.equals("and") || w.equals("a") || w.equals("is") || w.equals("of") || w.equals("in")) {
                continue;
            }
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        String[] uniqueWords = new String[map.size()];
        int[] counts = new int[map.size()];
        int idx = 0;
        for (String key : map.keySet()) {
            uniqueWords[idx] = key;
            counts[idx] = map.get(key);
            idx++;
        }
        for (int i = 0; i < uniqueWords.length - 1; i++) {
            for (int j = i + 1; j < uniqueWords.length; j++) {
                if (counts[i] < counts[j]) {
                    int tempCount = counts[i];
                    counts[i] = counts[j];
                    counts[j] = tempCount;
                    String tempWord = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = tempWord;
                }
            }
        }
        for (int i = 0; i < uniqueWords.length; i++) {
            System.out.println(uniqueWords[i] + ": " + counts[i]);
        }
    }
}
