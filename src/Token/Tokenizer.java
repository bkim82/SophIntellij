package Token;

import java.util.NoSuchElementException;

public class Tokenizer {
    private char[] tokenStr = null;
    private int pos = 0;

    public Tokenizer(String str) {
        tokenStr = str.toCharArray();
    }

    private void skipSpaces() {
        while (pos < tokenStr.length && Character.isSpaceChar(tokenStr[pos])) {
            pos++;
        }
    }

    private NumberToken readNumberToken() {
        int val = 0;

        while (pos < tokenStr.length && Character.isDigit(tokenStr[pos])) {
            int a = tokenStr[pos] - '0';
            val = val * 10 + a;

            pos++;
        }
        return new NumberToken(val);
    }

    private OperatorToken readOperatorToken() throws InvalidExpressionException {
        char c = tokenStr[pos];

        pos++;

        if (c == '+') {
            return new OpAddToken();
        }
        else if (c == '-') {
            return new OpSubToken();
        }
        else if (c == '/') {
            return new OpDivToken();
        }
        else if (c == '*') {
            return new OpMultToken();
        }
        else {
           throw new InvalidExpressionException("Found " + c + " expecting an operator " + pos + ".");
        }


    }

    public boolean hasMoreTokens() {
        skipSpaces();
        return (pos < tokenStr.length);

    }

    /** Returns next token in string.  If no more tokens,
     * throws a NoSuchElementException.
     */
    public Token nextToken() throws InvalidExpressionException {
        skipSpaces();

        if (pos >= tokenStr.length) {
            throw new NoSuchElementException("No more tokens remaining");
        }
        else if (Character.isDigit(tokenStr[pos])) {
            return readNumberToken();
        }
        else
            return readOperatorToken();
    }
}