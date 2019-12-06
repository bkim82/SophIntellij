package Token;

public class OpAddToken extends OperatorToken{


    public OpAddToken() {
        super('+');

    }
    public double eval (double a, double b) {
        return a+b;
    }
}
