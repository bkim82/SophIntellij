package Token;

public class OpSubToken extends OperatorToken {

    public OpSubToken() {
        super('-');
    }

    @Override
    public double eval(double a, double b) {
        return a-b;
    }

    public int getPrecedence() {
        return 1;
    }
}
