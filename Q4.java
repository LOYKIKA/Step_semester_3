public class Q4 {
    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(code.substring(0, 3)).append("] ")
          .append("YEAR: ").append(code.substring(3, 7))
          .append(" | CATALOG: ").append(code.substring(7, 13));
        return sb.toString();
    }
}