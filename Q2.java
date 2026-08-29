public class Q2 {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, original.length(), accuracy);

        if (firstMismatch != -1) {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n", firstMismatch, origChar, typedChar);
        } else {
            System.out.println("No Mismatches");
        }
    }
}