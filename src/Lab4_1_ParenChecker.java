
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Lab4_1_ParenChecker {

    public static int pos = 1;
    public static int line1 = 1;

    public static void main(String[] args) {
        String[] files = {"data/lab4_1/invalid1.in", "data/lab4_1/invalid2.in", "data/lab4_1/invalid3.in",
                "data/lab4_1/invalid4.in", "data/lab4_1/invalid5.in",
                "data/lab4_1/valid1.in", "data/lab4_1/valid2.in"};

        for (String filename : files) {
            System.out.println("\nTesting file: " + filename);
            try {
                checkParens(filename);
            } catch (FileNotFoundException ex) {
                System.err.println("File not found");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }


    public static void checkParens(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        ArrayList<Character> openSymbols = new ArrayList<>(Arrays.asList('[', '{', '('));
        ArrayList<Character> closeSymbols = new ArrayList<>(Arrays.asList(']', '}', ')'));
        Stack<Character> stack = new Stack<>();

        //
        // Declare any other variables you need here.
        //

        // Read through the file one line at a time.
        while (in.hasNextLine()) {
            String line = in.nextLine();
            char[] array = line.toCharArray();

            for (int i = 0; i < array.length; i++) {




                if (openSymbols.contains(array[i])) {
                    int a = openSymbols.indexOf(array[i]);
                    stack.push(closeSymbols.get(a));
                }

                if (closeSymbols.contains(array[i])) {
                    if (stack.isEmpty()) {
                        throw new InputMismatchException("On line " + line1 + " at pos " + pos + " found '" + array[i] + "' there" +
                                " is no matching opening8 symbol.");
                    }
                    if (stack.peek().equals(array[i])) {
                        stack.pop();
                    }

                    else {
                        int a = closeSymbols.indexOf(array[i]);
                        throw new InputMismatchException(("On line " + line1 + " at pos " + pos + " found '" + closeSymbols.get(a)) + "' " +
                                "expected '" + stack.peek() + "'");
                    }
                }
                pos++;
            }

            line1++;
            pos = 1;


        }

        if (!stack.isEmpty()) {
            int a = closeSymbols.indexOf(stack.peek());
            throw new InputMismatchException("At end of input -- expecting '" + closeSymbols.get(a) + "' ");

        }
        else {
            System.out.println("The parentheses in the file are valid!");
        }
    }
}