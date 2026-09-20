import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String csvLine = sc.nextLine();
        parseInventoryRecord(csvLine);
    }
    public static void parseInventoryRecord(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + parts[0] + " | SKU: " + parts[1] + " | Qty: " + parts[2]);
        }
    }
}
