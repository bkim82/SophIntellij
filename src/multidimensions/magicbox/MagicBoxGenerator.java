package multidimensions.magicbox;

import multidimensions.MultiDimArrayFundamentals;

import java.util.*;

public class MagicBoxGenerator {

    public static int solutionCount = 0;




    public static ArrayList<int[][]> generateMagicBox_v1(int rows, int columns) {
        ArrayList<int[][]> solutions = new ArrayList<>();
        generateMagicBox_v1(solutions, new int[rows][columns], 0);
        return solutions;
    }

    private static void generateMagicBox_v1(ArrayList<int[][]> solutions, int[][] box, int pos) {
        int rows = box.length;
        int columns = box[0].length;

        if (pos >= rows * columns) {
            solutionCount += 1;
            if (solutionCount % 10000 == 0) {
                System.out.println("Trying to find solution... Solution Count: " + solutionCount);
            }
        }

        if (pos >= rows * columns) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            return;
        }

        int row = pos / columns;
        int col = pos % columns;

        for (int num = 1; num <= rows * columns; num++) {
            box[row][col] = num;
            generateMagicBox_v1(solutions, box, pos+1);
        }
        box[row][col] = 0;
    }
    public static ArrayList<int[][]> generateMagicBox_v2(int rows, int columns) {
        ArrayList<int[][]> solutions = new ArrayList<>();
        boolean[] used = new boolean[rows * columns +1];

        generateMagicBox_v2(solutions, new int[rows][columns], 0, used);
        return solutions;
    }

    private static void generateMagicBox_v2(ArrayList<int[][]> solutions, int[][] box, int pos, boolean[] used) {
        int rows = box.length;
        int columns = box[0].length;

        if (pos >= rows * columns) {
            solutionCount += 1;
            if (solutionCount % 10000 == 0) {
                System.out.println("Trying to find solution... Solution Count: " + solutionCount);
            }
        }

        if (pos >= rows * columns) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            return;
        }

        int row = pos / columns;
        int col = pos % columns;

        for (int num = 1; num <= rows * columns; num++) {
            if (used[num]) {
                continue;
            }
            used[num] = true;

            box[row][col] = num;
            generateMagicBox_v2(solutions, box, pos+1, used);
            used[num] = false;

    }
        box[row][col] = 0;
    }

    public static ArrayList<int[][]> generateMagicBox_v3(int rows, int columns) {
        ArrayList<int[][]> solutions = new ArrayList<>();
        boolean[] used = new boolean[rows * columns +1];


        int n = rows * columns;
        int sum = n * (n+1) /2;
        int targetRowsum = sum / rows;

        generateMagicBox_v3(solutions, new int[rows][columns], 0, used, 0, targetRowsum);
        return solutions;
    }

    private static void generateMagicBox_v3(ArrayList<int[][]> solutions, int[][] box, int pos, boolean[] used,
                                            int rowsum, int targetRowsum) {
        int rows = box.length;
        int columns = box[0].length;

        if (pos >= rows * columns) {
            solutionCount += 1;
            if (solutionCount % 10000 == 0) {
                System.out.println("Trying to find solution... Solution Count: " + solutionCount);
            }
        }

        if (pos >= rows * columns) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            return;
        }

        int row = pos / columns;
        int col = pos % columns;

        boolean endOfRow = (columns -1 == col);

        for (int num = 1; num <= rows * columns; num++) {
            if (used[num]) {
                continue;
            }

            if (rowsum + num > targetRowsum) {
                break;
            }

            if (endOfRow && (rowsum + num != targetRowsum)) {
                continue;
            }
            used[num] = true;

            box[row][col] = num;
            generateMagicBox_v3(solutions, box, pos+1, used, endOfRow ? 0 : rowsum +num, targetRowsum);
            used[num] = false;

        }
        box[row][col] = 0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("ROWS?");
        int rows = input.nextInt();

        System.out.println("COLUMNS?");
        int columns = input.nextInt();

        ArrayList<int[][]> solutions = generateMagicBox_v3(rows, columns);

        System.out.println(solutions.size() + " solutions found");
        System.out.println();
        for (int[][] solution: solutions) {
            MultiDimArrayFundamentals.printArray(solution);
            System.out.println();
        }
        System.out.println("\n\n Tried " + solutionCount + " solutions.");
    }
}
