import Token.Token;
import Token.Tokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab4_2_PostfixCalculator {

    /**
     * calculatePostfix calculates and returns the value for the postfix
     * expression "postfixExp".  This method throws exceptions in the following
     * cases:
     * 1) If there are illegal characters in the input.
     * 2) If there are not enough values for a given operator.
     * 3) If there is more than 1 value remaining on the stack after the calculation completes.
     */
    public static double calculatePostfix(String postfixExp) {

        Tokenizer tk = new Tokenizer(postfixExp);
        while (tk.hasMoreTokens()) {
            Token t = tk.nextToken();

        return 0;
    }



    /**
     * Main opens the file specified in the first paramenter.  It then reads
     * through the file one line at a time.  For each line, it prints the original
     * line from the input and then prints the result.  If an exception occurs when
     * evaluating a specific link, print the message for the exception (using getMessage)
     * and then continue to the next line.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/lab4_2/postfix.in"));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println("\n" + line);

            try {
                double answer = calculatePostfix(line);
                System.out.println(answer);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
