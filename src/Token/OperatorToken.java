package Token;


public abstract class OperatorToken extends Token {
    public final char operator;

    public OperatorToken(char op) {
        operator = op;
    }

    public String toString() {
        return "" + operator;
    }

    public abstract double eval (double a, double b);

    public abstract int getPrecedence();
}