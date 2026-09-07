package string.week4_class_problems;

import java.util.Scanner;

public class DuplicateCheck {

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (containsDuplicate(nums)) {
            System.out.println("Contains Duplicate: true");
        } else {
            System.out.println("Contains Duplicate: false");
        }

        sc.close();
    }
}
