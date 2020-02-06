package multidimensions.connect4;

import multidimensions.connect4.Board;

import java.util.*;

public class ConnectFour {
  // Player 0 is Red; Player 1 is Yellow
  // Use the following arrays to get a label or checker letter for the player.
  static String colorLabelCaps[] = { "Red", "Yellow" };
  static String colorLabel[] = { "red", "yellow" };
  static char colorChar[] = { 'R', 'Y' };
  static int yORr = 0;



  public static void main(String[] args) {
    int player = 0;  // Player 0 is red; Player 1 is yellow.
    char a = 'R';
    String winner;

    Board board = new Board();
    Scanner input = new Scanner(System.in);
    String color = " ";
    // while there isn't a winner AND there isn't a draw
    while (board.checkWinner() == false && board.checkDraw() == false) {
      board.draw();
      System.out.println("-----------------\n");
      System.out.printf("Drop a red or yellow disk at column (0-6)");
      int chosenColumn = input.nextInt();
      if (yORr % 2 == 0) {
        a = 'R';
      }
      if(yORr % 2 == 1) {
        a = 'Y';
      }
      boolean columnEmpty = board.dropChecker(chosenColumn, a);
      yORr++;
      if (!columnEmpty) {
        System.out.println("\nColumn is full. Please enter a different column");
        player--;
      }
    }

    if (board.checkDraw()) {
      System.out.println("\nThe game ended in a draw.");
    }

    else {
      if (a == 'R') {
        color = "Red";
      }
      if (a == 'Y') {
        color = "Yellow";
      }
      System.out.println("\n" + color + " wins!");
    }


    System.out.println("Here is the final board: ");
    board.draw();
  }
}

