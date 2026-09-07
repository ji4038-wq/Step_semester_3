package string.week5_class_problems;

import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 65;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {

            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count++] = c;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(shortlisted[i].getCompositeScore())
                  .append(")");

            if (i != shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}

public class placementdriveshortlistingrankingEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Candidate " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Coding Score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(Candidate.shortlistAndRank(candidates));

        sc.close();
    }
}
