package ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex12_2 {
    public static void main(String[] args) {
        boolean run = true;

        while (run == true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter two integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("The sum is " + (a + b));
                run = false;
            }

            catch (InputMismatchException e) {
                System.out.println("Two integers required.");
                scanner.nextLine();
            }
        }
    }
}
