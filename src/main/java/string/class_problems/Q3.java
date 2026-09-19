import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] heights = new double[n];
        double[] weights = new double[n];
        for(int i=0; i<n; i++) {
            heights[i] = sc.nextDouble();
            weights[i] = sc.nextDouble();
        }
        printWellnessReport(heights, weights);
    }
    public static String getBmiStatus(double bmi) {
        if(bmi < 18.5) return "Underweight";
        if(bmi <= 24.9) return "Normal";
        if(bmi <= 29.9) return "Overweight";
        return "Obese";
    }
    public static void printWellnessReport(double[] heights, double[] weights) {
        for(int i=0; i<heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            double roundedBmi = Math.round(bmi * 100.0) / 100.0;
            System.out.println("Person " + (i+1) + " - Height: " + heights[i] + " m, Weight: " + weights[i] + " kg");
            System.out.println("BMI: " + roundedBmi + " | Status: " + status);
        }
    }
}
