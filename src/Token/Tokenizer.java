package Token;

import java.util.*;
import java.util.NoSuchElementException;

public class Tokenizer {
    private char[] tokenStr = null;
    private int pos = 0;
    ArrayList<Character> operators = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));

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
        else if (c == '*') {
            return new OpMultToken();
        }
        else if (c == '/') {
            return new OpDivToken();
        }
        else
            throw new InvalidExpressionException("Found " + c +
                    " expecting an operator at position " + pos + ".");

    }

    public boolean hasMoreTokens() {
        skipSpaces();
        return (pos < tokenStr.length);
    }

    public Token nextToken() throws InvalidExpressionException {
        skipSpaces();
        if (pos >= tokenStr.length) {
            throw new NoSuchElementException("No more tokens remaining.");
        }

        if (Character.isDigit(tokenStr[pos])) {
            return readNumberToken();
        }
        else if (operators.contains(tokenStr[pos])){
            return readOperatorToken();
        }
        else {
            char type = tokenStr[pos];
            pos++;

            if (type == '(') {
                return new LeftParenToken();
            }
            else if (type == ')') {
                return new RightParenToken();
            }
            else {
                throw new InvalidExpressionException();
            }
        }
    }
}