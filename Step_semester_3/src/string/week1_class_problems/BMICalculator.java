package string.class_problems;

import java.util.Random;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            heights[i] = 1.5 + (random.nextDouble() * 0.5);
            weights[i] = 45 + random.nextInt(56);
        }

        printWellnessReport(heights, weights);
    }
}
