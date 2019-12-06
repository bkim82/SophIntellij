package ex;

import java.util.Scanner;

public class Ex12_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] nums = createArray();

        System.out.print("Enter index: ");

        try {
            System.out.println("The matching value is " + nums[input.nextInt()]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds.");
        }
    }

    public static int[] createArray() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 100);
        }
        return nums;
    }
}