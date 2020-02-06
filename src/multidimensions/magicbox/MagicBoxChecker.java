package multidimensions.magicbox;


import multidimensions.MultiDimArrayFundamentals;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagicBoxChecker {
  public static boolean isSolution(int[][]box) {
    return isNormal(box) && isMagic(box);
  }

  /** Verifies that each value in the box is unique and in the range [1, m*n]. */
  public static boolean isNormal(int[][] box) {
    int m = box.length;
    int n = box[0].length;
    int size = m * n;

    boolean[] seen = new boolean[size+1];

    for (int i=0 ; i < m ; i++) {
      for (int j=0; j < n; j++) {
        int num = box[i][j];

        if ( num < 1 || num > size || seen[num]) {
          return false;
        }
        seen[num] = true;
      }
    }

    return true;
  }

  /** Assumes the box isNormal.
   * Verifies that each row and each column has the same sum.
   * (Note that columns can have different sums from rows for rectangles.)
   * For boxes, also check that the diagonals have this sum.
   */
  public static boolean isMagic(int[][] box) {
    int m = box.length;  // rows
    int n = box[0].length; // columns
    int size = m * n;

    int total =  size * (size+1) / 2;
    int rowsum = total / m;
    int colsum = total / n;

    for (int i=0; i < box.length; i++) {
      int rtotal = 0;
      for (int j=0; j<box[0].length; j++) {
        rtotal += box[i][j];
      }
      if (rtotal != rowsum) {
        return false;
      }
    }

    for (int j=0; j<box[0].length; j++) {
      int ctotal = 0;
      for (int i=0; i < box.length; i++) {
        ctotal += box[i][j];
      }
      if (ctotal != colsum) {
        return false;
      }
    }

    if (m == n) {
      int dsum = 0;
      for (int i=0; i < m ; i++) {
        dsum += box[i][i];
      }
      if (dsum != rowsum) {
        return false;
      }


      dsum = 0;
      for (int i=0; i < m ; i++) {
        dsum += box[i][m - 1 - i];
      }
      if (dsum != rowsum) {
        return false;
      }

    }

    return true;
  }


  public static void main(String args[]) throws Exception {
    String path = "data/magicboxes";
    Stream<Path> walk = Files.walk(Paths.get(path));

    List<String> result = walk.map(x -> x.toString())
            .filter(f -> f.endsWith(".txt")).collect(Collectors.toList());
    walk.close();

    for (String f : result) {
      System.out.println("\n\nTesting file: " + f);
      Scanner input = new Scanner(new FileReader(f));

      int m = input.nextInt();
      int n = input.nextInt();
      int[][] box = new int[m][n];

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          box[i][j] = input.nextInt();
        }
      }
      input.close();

      MultiDimArrayFundamentals.printArray(box);

      System.out.println("Normal?: " + isNormal(box));
      System.out.println("Magic?: " + isMagic(box));
    }
  }
}