package Token;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Lab4_3_InfixConverter {


	public static String infixToPostfix(String s) throws Exception {
		Stack<Token> opstack = new Stack<>();
		String output = "";
		Tokenizer tk = new Tokenizer(s);

		while (tk.hasMoreTokens()) {
			Token t = tk.nextToken();
			if (t instanceof NumberToken) {
				int t1 = (int)((NumberToken)t).value;
				output += t1 + " ";
			}
			else if (t instanceof LeftParenToken) {
				opstack.push(t);
			}
			else if (t instanceof RightParenToken) {
				while (!(opstack.peek() instanceof LeftParenToken)) {
					output += opstack.pop() + " ";
				}
				opstack.pop();
			}
			else if (t instanceof OperatorToken) {
				OperatorToken op = (OperatorToken)t;
				while (opstack.size() > 0 && (opstack.peek() instanceof OperatorToken)
						&& (((OperatorToken)opstack.peek()).getPrecedence() >= op.getPrecedence())) {
					output += opstack.pop() + " ";
				}
				opstack.push(op);
			}
		}
		while (opstack.size() > 0) {
			output += opstack.pop().toString() + " ";
		}
		return output;
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/lab4_3/infix.in"));

		while (in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println("\n" + line);

			try {
				String postfix = infixToPostfix(line);
				System.out.println("\t Postfix: " + postfix);

				double answer = Lab4_2_PostfixCalculator.calculatePostfix(postfix);
				System.out.println("\t Answer: " + answer);
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}

