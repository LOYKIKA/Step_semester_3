import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = sc.nextInt();
        int[] b = new int[n];
        for(int i=0; i<n; i++) b[i] = sc.nextInt();
        analyzeInventory(a, b);
    }
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0;
        int maxVal = -1;
        String maxLoc = "";
        for(int i=0; i<sectionA.length; i++) {
            sumA += sectionA[i];
            if(sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxLoc = "Section A, Item " + (i+1);
            }
        }
        int sumB = 0;
        for(int i=0; i<sectionB.length; i++) {
            sumB += sectionB[i];
            if(sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxLoc = "Section B, Item " + (i+1);
            }
        }
        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + sumA + " | Section B Total: " + sumB + " | Status: " + status + " | Highest Quantity: " + maxVal + " (" + maxLoc + ")");
    }
}
