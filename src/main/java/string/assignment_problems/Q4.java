import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);
        System.out.println(result);
    }
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(code.substring(0, 3)).append("] YEAR: ");
        sb.append(code.substring(3, 7));
        sb.append(" | CATALOG: ").append(code.substring(7));
        return sb.toString();
    }
}
