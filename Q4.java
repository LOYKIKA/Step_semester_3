public class InventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, maxQty, maxSection, maxIndex);
    }
}