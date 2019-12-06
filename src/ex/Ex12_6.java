package ex;

public class Ex12_6 {

  public static void main(String[] args) {
      try {
          if (hexToDecimal("F53A") == 62778)
              System.out.println("Passed 1");
          else
              System.out.println("Failed 1: Incorrect conversion result.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Failed 1: Unexpected exception.");
      }
      try {
          if (hexToDecimal("ba") == 186)
              System.out.println("Passed 2");
          else
              System.out.println("Failed 2: Incorrect conversion result.");

      }
      catch (NumberFormatException ex) {
          System.out.println("Failed 2: Unexpected exception.");
      }

      try {
          hexToDecimal("G3");
          System.out.println("Failed 3: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 3.");
      }

      try {
          hexToDecimal("g9");
          System.out.println("Failed 4: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 4.");
      }

      try {
          hexToDecimal("2*");
          System.out.println("Failed 5: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 5.");
      }

      try {
          hexToDecimal(">5");
          System.out.println("Failed 6: Did not catch illegal format.");
      }
      catch (NumberFormatException ex) {
          System.out.println("Passed 6.");
      }
  }


    public static int hexToDecimal(String hex) {
        for (int i = 0; i < hex.length(); i++) {
            char c = Character.toUpperCase(hex.charAt(i));
            if (!(c >= 'A' && c <= 'F') && !(c >= '0' && c <= '9')) {
                throw new NumberFormatException();
            }
        }

        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = Character.toUpperCase(hex.charAt(i));
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else {
            return ch - '0';
        }
    }
}
