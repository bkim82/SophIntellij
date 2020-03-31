package anagrams;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramFinder {

  public static List<String> getAnagrams(String word, LookupList dict){
    ArrayList<String> words = new ArrayList<String>();
    getAnagrams(word, "", dict, words);
    return words;
  }

  private static void getAnagrams(String word, String newAnagram, LookupList dict, List<String> groups) {

    if (word.length() == 0) {
      newAnagram = newAnagram.toUpperCase();
      if (dict.contains(newAnagram)) {
        if (!groups.contains(newAnagram)) {
          groups.add(newAnagram);
        }
      }
    }
    else {
      for (int i = 0; i < word.length(); i++) {
        getAnagrams(word.substring(0, i) + word.substring(i+1),
                newAnagram + word.charAt(i), dict, groups);
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);

    System.out.println("Which word list?  (large, medium, small, tiny)");
    String listSize = input.nextLine();
    String filename = "data/scrabbleWords/words_" + listSize + ".txt";

    System.out.printf("Reading in word list from file %s...\n", filename);
    double start = System.nanoTime();
    LookupList dict = new LookupList(filename);
    System.out.print("Successfully read in word list from file!\n");
    System.out.printf("Time: %.4f seconds.\n\n", (System.nanoTime() - start) / 1000000000);

    System.out.print("\n\nEnter word/letters to find anagrams (enter blank to stop) >>>  ");
    String word = input.nextLine();
    while (!word.equals("")) {
      start = System.nanoTime();
      System.out.printf("Searching for anagrams of \"%s\"...\n", word);
      List<String> anagrams = getAnagrams(word, dict);
      System.out.printf("Found %d anagrams!\n", anagrams.size());
      System.out.println(anagrams);
      System.out.printf("Time: %.4f seconds.\n\n", (System.nanoTime() - start) / 1000000000);

      System.out.print("Enter another word to find anagrams >>> ");
      word = input.nextLine();
    }
    System.out.println("All done!");
  }


}