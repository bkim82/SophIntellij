package Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Lab4_2_PostfixCalculator  {


    public static double calculatePostfix(String postfixExp) throws InvalidExpressionException {

        Stack<Double> stack = new Stack<>();

        Tokenizer tk = new Tokenizer(postfixExp);

        double second;
        double first;

        while (tk.hasMoreTokens()) {
            Token t = tk.nextToken();
            if (t instanceof NumberToken) {
                stack.push(((NumberToken)t).value);
            }
            else if (t instanceof OperatorToken) {
                OperatorToken op = (OperatorToken)t;
                if (stack.size() < 2) {
                    throw new InvalidExpressionException("Too " +
                            "few values on stack for operator " + op);
                }
                else {
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(op.eval(first, second));

                }
            }


        }
        if (stack.size() == 1) {
            return stack.peek();
        }
        else {
            throw new InvalidExpressionException("Too few operators in the expression. " +
                    "Stack has " + stack.size() + " elements at the end of the expression.");
        }


    }

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
