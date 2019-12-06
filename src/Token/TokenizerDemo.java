package Token;

import java.util.*;

public class TokenizerDemo {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = in.nextLine();

        Tokenizer tk = new Tokenizer(s);
        while (tk.hasMoreTokens()) {
            Token t = tk.nextToken();
            System.out.println(t);

            if (t instanceof OperatorToken) {
                OperatorToken opt = (OperatorToken)t;
                System.out.println(opt.eval(5,17));
            }
        }
    }
}
