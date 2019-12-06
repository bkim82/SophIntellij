package day1;

import java.util.*;

public class Day3_Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a list of numbers.");
        ArrayList<Integer> ints = new ArrayList<>();

        int n = in.nextInt();
        while (n != 0) {
            ints.add(n);
            n = in.nextInt();
        }

        System.out.println("\n\n");
        for (int i = ints.size() - 1; i >= 0; i--) {
            System.out.println(ints.get(i) + " ");

        }
    }
}
