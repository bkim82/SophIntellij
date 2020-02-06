package multidimensions.connect4;

/** Implements a ConnectFour board */
public class Board {
  static final int ROWS = 6; // The number of rows on the board.
  static final int COLUMNS = 7; // The number of columns on the board.

  // board is the instance variable that stores the actual board, a 2-array of chars.
  // The possible characters stored in the board include:
  //  ' ' - Empty Space
  //  'R' - Red checker
  //  'Y' - Yellow checker
  private char[][] board;

  /**
   * Constructor of a Board object.
   * <p>
   * Instantiates the 'board' variable and initializes all of the cells to ' '.
   */
  public Board() {
    this.board = new char[ROWS][COLUMNS];
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        board[i][j] = ' ';
      }
    }
  }

  /**
   * Writes the current board to System.out, per the format in the assignment PDF.
   */
  public void draw() {
//    System.out.printf("|");

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {

        System.out.printf(board[i][j] + "|");
      }
      System.out.printf("\n");
    }
  }

  /**
   * Attempts to drop the specified checker in the specified column.  If the checker is
   * successfully dropped, the method adds the checker to the board variable and returns true.
   * If the specified column is full, the method returns false.
   */
  public boolean dropChecker(int column, char checker) {

    for (int i = ROWS-1; i >= 0; i--) {
      if (board[i][column] == ' ') {
        board[i][column] = checker;
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if the game has a winner.  The method returns true if either user
   * has four in a row in any direction.
   **/
  public boolean checkWinner() {

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS - 4; j++) {

        if (board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]) {
          return true;
        }

      }
    }
    for (int i = 0; i < ROWS-4; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (board[i][j] != ' ' && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j]) {
          return true;
        }
      }
    }

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        try {
          if (board[i][j] != ' ' && board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2] && board[i][j] == board[i + 3][j - 3]) {
            return true;
          }
        }
        catch (ArrayIndexOutOfBoundsException e) { }
        try {
          if (board[i][j] != ' ' && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3]) {
            return true;
          }
        }
        catch (ArrayIndexOutOfBoundsException e) { }

      }
    }

    return false;
  }


  /**
   * Determines if the game is a draw.
   * This method assumes the user already checked if there is a winner via a call to
   * checkWinner. This method returns true if there are no more blank squares.
   */
  public boolean checkDraw() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (board[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }
}