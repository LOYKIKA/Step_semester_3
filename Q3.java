public class Q3 {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.printf("Product: %s | SKU: %s | Qty: %s\n",
                fields[0].trim(), fields[1].trim(), fields[2].trim());
    }
}