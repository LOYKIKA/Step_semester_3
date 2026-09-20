import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        String result = validateFileExtension(filename);
        System.out.println(result);
    }
    public static String validateFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected - invalid file type";
        }
        String ext = filename.substring(lastDot + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected - invalid file type";
    }
}
